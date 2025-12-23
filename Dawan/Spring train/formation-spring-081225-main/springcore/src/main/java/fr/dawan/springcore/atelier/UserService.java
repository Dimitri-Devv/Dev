package fr.dawan.springcore.atelier;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Service("userservice")
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;
}
