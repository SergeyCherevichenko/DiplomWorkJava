package uz.cherevichenko.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
    private final String phoneNumber;
    private final String password; // Если вы используете пароль
    private final boolean isVerified;

    public CustomUserDetails(String phoneNumber, String password, boolean isVerified) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.isVerified = isVerified;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Возвращайте роли или права доступа пользователя
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return phoneNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isVerified;
    }
}

