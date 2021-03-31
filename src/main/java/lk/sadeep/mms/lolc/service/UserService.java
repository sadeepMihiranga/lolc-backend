package lk.sadeep.mms.lolc.service;

import lk.sadeep.mms.lolc.dto.MainPageDTO;
import lk.sadeep.mms.lolc.dto.UserDTO;
import lk.sadeep.mms.lolc.entiry.MainPage;
import lk.sadeep.mms.lolc.exception.DataNotFoundException;

import java.util.List;

public interface UserService
{
    UserDTO createAnUser(UserDTO userDTO);

    UserDTO login(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO getAUser(Integer id);

    UserDTO updateUser(UserDTO userDTO);

    void deleteAUser(Integer id);

    List<MainPage> getPages(Integer id);
}
