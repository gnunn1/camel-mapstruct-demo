package com.redhat.demo.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.redhat.demo.model.AgencyFile;
import com.redhat.demo.model.CourtCaseData;

@Mapper(uses = { AccusedPersonToAccusedMapper.class })
public interface CaseDataToAgencyFileMapper {
 
    public static final String M69_VUL1 = "m69 VUL1";

    CaseDataToAgencyFileMapper INSTANCE = Mappers.getMapper( CaseDataToAgencyFileMapper.class ); 
 
    @Mapping(source = "accusedPerson", target = "accused")
    @Mapping(source = "caseFlags", target = "vul1", qualifiedByName = "vul1")
    AgencyFile transform(CourtCaseData data);

    @Named("vul1")
    default String lookupVuln1Flag(List<String> flags) {
        return flags.contains(M69_VUL1)? "Y":"N";
    }    

}