package com.redhat.demo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.redhat.demo.model.Accused;
import com.redhat.demo.model.AccusedPerson;

@Mapper
public interface AccusedPersonToAccusedMapper {
    
    @Mapping(source = "identifier", target = "partId")
    @Mapping(source = "fullName", target = "accusedName")
    @Mapping(source = "offenceDate", target = "offenceFromDate")
    Accused transform(AccusedPerson data); 
    
}
