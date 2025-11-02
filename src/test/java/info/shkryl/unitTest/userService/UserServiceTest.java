package info.shkryl.unitTest.userService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnUserNameWhenUserExists() {
        // given
        Long userId = 1L;
        User user = new User("Alice");
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // when
        String name = userService.getUserNameById(userId);

        // then
        assertEquals("Alice", name);
    }

    @Test
    void shouldReturnUnknownWhenUserDoesNotExist() {
        // given
        Long userId = 999L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // when
        String name = userService.getUserNameById(userId);

        // then
        assertEquals("Unknown", name);
    }
}