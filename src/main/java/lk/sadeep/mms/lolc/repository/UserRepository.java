package lk.sadeep.mms.lolc.repository;

import lk.sadeep.mms.lolc.entiry.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>
{
    boolean findByEmail(String email);

    User findByUsername(String name);

    List<User> findByActiveStatus(Integer status);
}
