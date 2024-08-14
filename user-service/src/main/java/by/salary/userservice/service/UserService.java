package by.salary.userservice.service;

import by.salary.userservice.entity.User;
import by.salary.userservice.exceptions.UserNotFoundException;
import by.salary.userservice.model.UserRequestDTO;
import by.salary.userservice.model.UserResponseDTO;
import by.salary.userservice.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    public List<UserResponseDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(UserResponseDTO::new)
                .toList();
    }

    public UserResponseDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found", HttpStatus.NOT_FOUND);
        }
        return new UserResponseDTO(user.get());

    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = modelMapper.map(userRequestDTO, User.class);
        return new UserResponseDTO(userRepository.save(user));
    }

    public UserResponseDTO deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found", HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
        return modelMapper.map(user.get(), UserResponseDTO.class);
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found", HttpStatus.NOT_FOUND);
        }
        User updatedUser = User.builder()
                .id(id)
                .login(userRequestDTO.getLogin() == null ? user.get().getLogin() : userRequestDTO.getLogin())
                .password(userRequestDTO.getPassword() == null ? user.get().getPassword() : userRequestDTO.getPassword())
                .email(userRequestDTO.getEmail() == null ? user.get().getEmail() : userRequestDTO.getEmail())
                .name(userRequestDTO.getName() == null ? user.get().getName() : userRequestDTO.getName())
                .surname(userRequestDTO.getSurname() == null ? user.get().getSurname() : userRequestDTO.getSurname())
                .lastname(userRequestDTO.getLastname() == null ? user.get().getLastname() : userRequestDTO.getLastname())
                .build();
        return modelMapper.map(userRepository.save(updatedUser), UserResponseDTO.class);
    }
}
