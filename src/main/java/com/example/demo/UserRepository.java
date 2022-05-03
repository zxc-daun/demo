package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    /** Jpa Methods */

    // find top 2 users where name starts with `name`
    List<User> findTop2ByNameStartsWith(String name);

    // find users by name and surname (?1, ?2)
    List<User> findByNameAndSurname(String name, String surname);

    // find users where email contains `email` sorted by surname (asc)
    List<User> findFirstByEmailContainingOrderBySurname(String email);
    List<User> findByEmailEndsWith(String email1);


    List<User> findBySurnameContaining(String surname3);

    List<User> findByOrderById();

    List<User> findTop2ByOrderByIdDesc();

    List<User> findByOrderByNameDesc();

    List<User> findByEmailNotContaining(String email7);

    List<User> findDistinctTop1ByName(String name10);

    List<User> findByEmailContainingOrderByNameDesc(String email);
    /** Native Query */

    // find users where name starts with `A` order by surname (asc)
    @Query(value = "select * from users where name like 'A%' order by surname", nativeQuery = true)
    List<User> findAllSorted();

    // find users where id greater than `qid`
    @Query(value = "select * from users where id > :qid", nativeQuery = true)
    List<User> findByGreaterId(Long qid);

    @Query(value = "select * from users where email like '%gmail.com' or email like '%narxoz.kz' or email like '%yandex.ru'", nativeQuery = true)
    List<User> findAllQ();

    @Query(value = "select * from users where name = surname", nativeQuery = true)
    List<User> findAllW();

    @Query(value = "select distinct on (name) * from users", nativeQuery = true)
    List<User> findAllE();
}


/*public interface UserRepository extends JpaRepository<User, Long> {
    // Jpa

    List<User> findByEmailEndsWith(String email1);

    List<User> findTop2ByNameStartsWith(String name2);

    List<User> findBySurnameContaining(String surname3);

    List<User> findByOrderById();

    List<User> findTop2ByOrderByIdDesc();

    List<User> findByOrderByNameDesc();

    List<User> findByEmailNotContaining(String email7);

    List<User> findDistinctTop1ByName(String name10);

    List<User> findByEmailContainingOrderByNameDesc(String email);

    // Native Query
    @Query(value = "select * from users where email like '%gmail.com' or email like '%narxoz.kz' or email like '%yandex.ru'", nativeQuery = true)
    List<User> findAllQ();

    @Query(value = "select * from users where name = surname", nativeQuery = true)
    List<User> findAllW();

    @Query(value = "select distinct on (name) * from users", nativeQuery = true)
    List<User> findAllE();
}

public interface UserRepository extends JpaRepository<User, Long> {

    // Jpa
    List<User> findByNameStartsWith(String name);

    List<User> findByEmailContainingOrderByNameDesc(String email);

    // Native Query
    @Query(value = "select * from users order by surname", nativeQuery = true)
    List<User> findAllSorted();

    @Query(value = "select * from users where id > :qid", nativeQuery = true)
    List<User> findByGreaterId(Long qid);

    @Query(value = "select * from users where id > :qid", nativeQuery = true)
    List<User> findByGreaterId(Long qid);
}*/