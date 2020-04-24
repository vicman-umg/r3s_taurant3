package com.pos.restaurante.app.models.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pos.restaurante.app.models.dao.ITbUsuarioDao;
import com.pos.restaurante.app.models.entity.TbRolUsuario;
import com.pos.restaurante.app.models.entity.TbUsuario;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private ITbUsuarioDao usuarioDao;
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TbUsuario usuario = usuarioDao.findByUsuarioCodigo(username);
		
		System.out.println(usuario);
		
		if (usuario == null) {
		logger.error("Error login: no existe el usuario '" + username + "'");	
		throw new UsernameNotFoundException("Username " +username+" no existe en el sistema!");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (TbRolUsuario role : usuario.getTbRolUsuarios()) {
			logger.info("Role: ".concat(role.getTbAppRol().getRolNombre()));
			authorities.add(new SimpleGrantedAuthority(role.getTbAppRol().getRolNombre()));
		}
		
		if (authorities.isEmpty()) {
			logger.error("Error login: usuario '" + username + "' no tiene roles asignados");	
			throw new UsernameNotFoundException("Error login: usuario '" + username + "' no tiene roles asignados");
			}
		
		return new User(usuario.getUsuId(), usuario.getUsuPassword(), usuario.getUsuEnabled(), true, true, true, authorities);
	}

}
