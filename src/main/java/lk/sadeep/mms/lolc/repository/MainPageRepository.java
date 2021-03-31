package lk.sadeep.mms.lolc.repository;

import lk.sadeep.mms.lolc.entiry.MainPage;
import lk.sadeep.mms.lolc.entiry.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MainPageRepository extends JpaRepository<MainPage, Integer>
{
    List<MainPage> findByUserRoleIdAndActiveStatus(Integer userRoleId, Integer activeStatus);
}
