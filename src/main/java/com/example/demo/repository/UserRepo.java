package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

/**
 * INTERFAZ QUE NOS PERMITE COMUNICARNOS CON EL REPOSITORIO DEL USUARIO
 * 
 * @author adela
 *
 */
public interface UserRepo extends JpaRepository<User, Long> {

	/**
	 * METODO QUE NOS ENCUENTRA EL EMAIL DEL USUARIO
	 * 
	 * @param email
	 * @return
	 */
	public User findByEmail(String email);

	/**
	 * Query para conseguir a un usuario a través de una cadena de string recibida.
	 * No incluye al propio usuario en el resultado
	 * 
	 * @param busqueda
	 * @return
	 */
	@Query(value = "SELECT * FROM usuario WHERE id != :idUser AND username LIKE %:username%", nativeQuery = true)
	public List<User> findByUsername(Long idUser, String username);
	//@Query(value = "SELECT * FROM usuario WHERE username LIKE %$1%", nativeQuery = true)
	//public List<User> findByUsername(String username, Long idUser);
	
	/**
	 * Selecciona a los usuarios cuyos usernames coincidan con la búsqueda introducida y sean amigos del usuario que realiza la búsqueda.
	 * @param username
	 * @param idUser
	 * @return lista de usuarios
	 */
	@Query(value = "SELECT * FROM usuario WHERE username LIKE %:username% AND id != :idUser AND id IN (SELECT friends_id FROM usuario_friends WHERE user_id = :idUser)", nativeQuery = true)
	public List<User> findFriendsByUsername(String username, Long idUser);
	
	/**
	 * Encuentra los id de los usuarios que sean amigos de un usuario en concreto
	 * @param idUser
	 * @param idFriend
	 * @return id del ususario ya amigo
	 */
	@Query(value= "SELECT friends_id FROM usuario_friends WHERE user_id = ?1 AND friends_id = ?2", nativeQuery = true)
	public Long findUsersToAddFriends(Long idUser, Long idFriend);

	/**
	 * Query que nos consigue todos los usuarios que tenemos registrados en la base
	 * de datos
	 * 
	 * @return
	 */
	@Query(value = "select * from usuario", nativeQuery = true)
	public List<User> findAllUsers();

	/**
	 * Query para conseguir a un usuario a través de su username
	 * 
	 * @param busqueda
	 * @return
	 */
	@Query(value = "SELECT * FROM usuario WHERE username = ?1", nativeQuery = true)
	public User findByUsernameComplete(String username);

	/**
	 * Encuentra a los amigos del usuario que le indiquemos
	 * @param long1
	 * @return
	 */
	@Query(value = "SELECT friends_id FROM usuario_friends WHERE user_id = ?1", nativeQuery = true)
	public List<Long> searchFriends(Long long1);

	/**
	 * Encuentra todos los usuarios
	 * 
	 * @return
	 */
	@Query(value = "SELECT * FROM usuario", nativeQuery = true)
	public List<User> findUsers();


	/**
	 * Elimina la relación entre usuarios y amigos.
	 * De esta manera, cuando se elimine a un usuario, esta query
	 * eliminará la relación entre ambos.
	 * @param idUser
	 */
	@Modifying //declare that it is an update query and you don't expect a result back from the DB
	@Transactional
	@Query(value="DELETE FROM usuario_friends WHERE friends_id = ?1 OR user_id = ?1", nativeQuery = true)
	public void deleteUserFriends(Long idUser);

	/**
	 * Consigue la propiedad message que indica si se le ha enviado un mensaje al usuario
	 * @return message (boolean)
	 */
	@Query(value = "SELECT message FROM usuario", nativeQuery = true)
	public List<Boolean> getPropertyMessage();

}