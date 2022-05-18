package realization.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import realization.model.User;
import realization.repository.UserRepository;
import realization.security.UserPrincipal;
import realization.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public User getAuthorisedUser() {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = userPrincipal.getUsername();
        return userRepository.findUserByLogin(login);
    }
}
