package by.salary.userservice.controller;

import by.salary.userservice.exceptions.UserNotFoundException;
import by.salary.userservice.model.UserRequestDTO;
import by.salary.userservice.model.UserResponseDTO;
import by.salary.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User controller", description = "User management system")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "View a list of available users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Get a user by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved user"),
            @ApiResponse(responseCode = "404", description = "The user you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO getUserById(@Parameter(description = "ID of the user to be obtained", required = true) @PathVariable Long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @Operation(summary = "Add a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created user")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@Parameter(description = "User data to be created", required = true) @RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);
    }

    @Operation(summary = "Delete a user by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted user"),
            @ApiResponse(responseCode = "404", description = "The user you were trying to delete is not found")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO deleteUser(@Parameter(description = "ID of the user to be deleted", required = true) @PathVariable Long id) throws UserNotFoundException {
        return userService.deleteUser(id);
    }

    @Operation(summary = "Update a user by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated user"),
            @ApiResponse(responseCode = "404", description = "The user you were trying to update is not found")
    })
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO updateUser(@Parameter(description = "ID of the user to be updated", required = true) @PathVariable Long id,
                                      @Parameter(description = "Updated user data", required = true) @RequestBody UserRequestDTO userRequestDTO) throws UserNotFoundException {
        return userService.updateUser(id, userRequestDTO);
    }
}
