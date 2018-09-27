package com.demo.client.service;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.ironrhino.core.security.role.UserRole;
import org.ironrhino.core.spring.configuration.Fallback;
import org.ironrhino.core.spring.configuration.StageConditional;
import org.ironrhino.core.util.AppInfo.Stage;
import org.ironrhino.core.util.AuthzUtils;
import org.ironrhino.security.domain.User;
import org.ironrhino.security.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@StageConditional(value = Stage.DEVELOPMENT)
@Fallback
public class FallbackUserService implements UserService {

	private Map<String, User> map = new ConcurrentHashMap<>();

	@Override
	public User loadUserByUsername(String username) {
		if ("test".equals(username)) {
			return map.computeIfAbsent(username, key -> {
				User user = new User();
				user.setUsername(key);
				user.setEnabled(true);
				user.setName(key);
				user.setPassword(AuthzUtils.encodePassword(user, key));
				user.setAuthorities(Collections.singleton(new SimpleGrantedAuthority(UserRole.ROLE_BUILTIN_USER)));
				return user;
			});
		}
		return null;
	}

}
