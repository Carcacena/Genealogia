package br.com.jose.service;

import java.util.HashSet;
import java.util.Set;

public class BlacklistService {

	 private final Set<String> blacklist = new HashSet<>();

	    // Adiciona token à lista
	    public void add(String token) {
	        blacklist.add(token);
	    }

	    // Verifica se token está bloqueado
	    public boolean isBlacklisted(String token) {
	        return blacklist.contains(token);
	    }
	
	
	
	
	
	
	
}
