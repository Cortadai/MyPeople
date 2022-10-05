package com.example.springboot.service.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dto.security.UserDto;
import com.example.springboot.entity.security.Role;
import com.example.springboot.entity.security.User;
import com.example.springboot.repository.security.RoleRepository;
import com.example.springboot.repository.security.UserRepository;




@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;

	RoleRepository roleRepository;
	
	ModelMapper modelMapper;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public List<User> searchJQPL(String query) {
		return userRepository.searchUser(query);
	}
	
	@Override
	public String updateUser(User user, long id) {
		String mensaje = " ";

		User existingUserId = userRepository.findById(id).get();
		// Product existingProduct = productRepository.findBySku(sku).get();

		if (existingUserId != null) {
			//user.setId(id);

			existingUserId.setName(user.getName());
			existingUserId.setEmail(user.getEmail());
			existingUserId.setPassword(user.getPassword());
			existingUserId.setUsername(user.getUsername());
			existingUserId.setActive(user.isActive());
			/*
			List<Role> listRole = new ArrayList<>();
			listRole.addAll(user.getRoles());
			
			Role miRole = roleRepository.findByName(listRole.get(0).getName());
			existingUserId.getRoles().add(miRole);
		*/
			userRepository.save(existingUserId);
			mensaje = "usuario actualizado";
		} else {
			mensaje = "usuario no existe en base de datos";
		}
		return mensaje;
	}

	@Override
	public String deleteUser(User user, long id) {
		String mensaje = " ";

		User existingUserId = userRepository.findById(id).get();

		if (existingUserId != null) {
			user.setId(id);
			
			//emailService.sendEmail(buildEmailBody(existingUserId.getEmail()));
			
			userRepository.delete(existingUserId);
			mensaje = "usuario eliminado";
		} else {
			mensaje = "usuario no eliminado";
		}
		return mensaje;
	}
/*
	private EmailBody buildEmailBody(String email) {
		//LOGGER.info("Local environment: " + environment.getProperty("local.environment"));
	
		return new EmailBody(email,
		        "Operation completed successfully for user", "Archive in bulk");
	}*/

	@Override
	public User createUser(User user) {
		Role roleUsuario = roleRepository.findByName("ROLE_USER");
		user.addRole(roleUsuario);
		return userRepository.save(user);
	}

	@Override
	public List<User> buscarTodosUsers() {
		List<User> users = userRepository.findAll(); 
		return users;
	}


	
	/////////////////////
	
	@Override
	public List<UserDto> searchJQPL2(String query) 
	
	{
		List<UserDto>  listaDto = new ArrayList<UserDto>();
		List<User> lista = userRepository.searchUser(query);
		for (User userlista : lista) {
			listaDto.add(maptoDto(userlista));
		}
		return listaDto;
	}

	@Override
	public List<UserDto> buscarTodosUsers2() {
		List<UserDto>  listaDto = new ArrayList<UserDto>();
		
		List<User> users = userRepository.findAll();
		for (User userlista : users) {
			listaDto.add(maptoDto(userlista));
		}
		return listaDto;
	}

	@Override
	public UserDto createUser2(UserDto user) {
		// creamos el objeto vario para devolver que pide este metodo
		UserDto userDto = new UserDto();
		// convertimos lo que llega (dto) en lo que se graba (entity)
		User usuarioConvertido = maptoEntity(user);
		// hacemos la operacion con la entidad ya convertida
		User usuarioSalvado = userRepository.save(usuarioConvertido);
		// convertimos lo que hemos salvado (user) en lo que se devuelve (dto)
		userDto = maptoDto(usuarioSalvado);
		// devolvemos el dto que al principio estaba vacio
		return userDto;
	}

	@Override
	public String deleteUser2(UserDto user, long id) {
		UserDto userDto = new UserDto();
		User usuarioConvertido = maptoEntity(user);
		userRepository.delete(usuarioConvertido);
		return "Usuario eliminado";
		
	}

	@Override
	public String updateUser2(UserDto user, long id) {
		UserDto userDto = new UserDto();
		User usuarioConvertido = maptoEntity(user);
		String mensaje = "";
		User existingUserId = userRepository.findById(id).get();
		// Product existingProduct = productRepository.findBySku(sku).get();

		if (existingUserId != null) {
			//user.setId(id);

			existingUserId.setName(usuarioConvertido.getName());
			existingUserId.setEmail(usuarioConvertido.getEmail());
			existingUserId.setPassword(usuarioConvertido.getPassword());
			existingUserId.setUsername(usuarioConvertido.getUsername());
			existingUserId.setActive(usuarioConvertido.isActive());
			
			userRepository.save(existingUserId);
			mensaje = "usuario actualizado";
		} else {
			mensaje = "usuario no existe en base de datos";
		}
		return mensaje;

	}
	
	/*
	 * @Autowired
	public ProviderServiceImpl(ProviderRepository providersRepository, ModelMapper modelMapper) {
		this.providersRepository = providersRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProviderDto getProviderById(Integer id) {
		Provider provider = providersRepository.findById(id).get();
		return maptoDto(provider);
	}

	
	}*/
	 
	 private UserDto maptoDto(User user) {
			return modelMapper.map(user, UserDto.class);
	 }
	 
	 private User maptoEntity(UserDto dto) {
			return modelMapper.map(dto, User.class);
	 }
}
