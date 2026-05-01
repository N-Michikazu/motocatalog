package jp.co.planaria.sample.motocatalog.beans;

import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails{


    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
        // または: return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return this.password;    
    }

    @Override
    public String getUsername() {
        return username;

    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    
    }
    @Override
    public boolean isEnabled() {
        return true;
    
    }
}
