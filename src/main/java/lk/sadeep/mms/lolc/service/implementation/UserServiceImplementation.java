package lk.sadeep.mms.lolc.service.implementation;

import lk.sadeep.mms.lolc.dto.MainPageDTO;
import lk.sadeep.mms.lolc.dto.SubPageDTO;
import lk.sadeep.mms.lolc.dto.UserDTO;
import lk.sadeep.mms.lolc.dto.UserRoleDTO;
import lk.sadeep.mms.lolc.entiry.MainPage;
import lk.sadeep.mms.lolc.entiry.SubPage;
import lk.sadeep.mms.lolc.entiry.User;
import lk.sadeep.mms.lolc.entiry.UserRole;
import lk.sadeep.mms.lolc.exception.DataNotFoundException;
import lk.sadeep.mms.lolc.exception.DuplicateEntryException;
import lk.sadeep.mms.lolc.repository.MainPageRepository;
import lk.sadeep.mms.lolc.repository.UserRepository;
import lk.sadeep.mms.lolc.service.UserService;
import lk.sadeep.mms.lolc.util.AppConstants;
import lk.sadeep.mms.lolc.util.CommonUtil;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class UserServiceImplementation implements UserService
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    MainPageRepository mainPageRepository;

    @Override
    public UserDTO createAnUser(UserDTO userDTO)
    {
        UserDTO insertedUser = null;

        try
        {
            User user = new User(
                    userDTO.getUsername(),
                    userDTO.getPassword(),
                    userDTO.getFullName(),
                    userDTO.getContactNumber(),
                    userDTO.getCreatedBy(),
                    userDTO.getEmail(),
                    new UserRole(userDTO.getUserRoleDTO().getId()));

            insertedUser = getUserDTOByUser(userRepository.save(user));
        }
        catch (DataIntegrityViolationException e)
        {
            throw new DuplicateEntryException("Duplication found");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return insertedUser;
    }

    @Override
    public UserDTO login(UserDTO userDTO)
    {
        User user = userRepository.findByUsername(userDTO.getUsername());

        if(user != null)
        {
            if(user.getPassword().equals(userDTO.getPassword()))
                return getUserDTOByUser(user);
        }

        return new UserDTO();
    }

    @Override
    public List<UserDTO> getAllUsers()
    {
        List<UserDTO> userDTOList = new ArrayList<>();

        userRepository.findByActiveStatus(1).forEach(user -> userDTOList.add(getUserDTOByUser(user)));

        return userDTOList;
    }

    @Override
    public UserDTO getAUser(Integer id)
    {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new DataNotFoundException("User not found");
        });
        return getUserDTOByUser(user);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO)
    {
        AtomicReference<User> users = new AtomicReference<>();

        userRepository.findById(userDTO.getId()).ifPresent(user -> {

            user.setContactNumber(userDTO.getContactNumber());
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setFullName(userDTO.getFullName());
            user.setUserRole(new UserRole(userDTO.getUserRoleDTO().getId()));
            user.setUpdatedBy(userDTO.getUpdatedBy());

            users.set(userRepository.save(user));
        });

        if(users.get() == null)
            throw new DataNotFoundException("User not found");
        else
            return getUserDTOByUser(users.get());
    }

    @Override
    public void deleteAUser(Integer id)
    {
        AtomicReference<User> users = new AtomicReference<>();

        userRepository.findById(id).ifPresent(user -> {

            user.setActiveStatus(0);

            users.set(userRepository.save(user));
        });

        if(users.get() == null)
            throw new DataNotFoundException("User not found");
    }

    @Override
    public List<MainPage> getPages(Integer id)
    {
        List<MainPage> mainPages = mainPageRepository.findByUserRoleIdAndActiveStatus(id, 1);

        return mainPages;
    }

    private static UserDTO getUserDTOByUser(User user)
    {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                AppConstants.PASSWORD_STRING,
                user.getFullName(),
                user.getContactNumber(),
                user.getCreatedBy(),
                CommonUtil.convertDateTime(user.getCreatedDate(), AppConstants.DATE_FORMAT_BASIC),
                user.getUpdatedBy(),
                CommonUtil.convertDateTime(user.getUpdatedDate(), AppConstants.DATE_FORMAT_BASIC),
                user.getLoggingAttempts(),
                user.getActiveStatus(),
                user.getEmail(),
                new UserRoleDTO(
                        user.getUserRole().getId(),
                        user.getUserRole().getRole(),
                        user.getUserRole().getRole()));
    }
}
