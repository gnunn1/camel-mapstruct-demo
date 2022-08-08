package com.redhat.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.jboss.logging.Logger;

import com.redhat.demo.mappers.CaseDataToAgencyFileMapper;
import com.redhat.demo.model.AgencyFile;
import com.redhat.demo.model.CourtCaseData;

public class TransformCourtCaseDataProcessor implements Processor {

    private static final Logger LOG = Logger.getLogger(TransformCourtCaseDataProcessor.class);

    public void process(Exchange exchange) throws Exception {
        AgencyFile agencyFile = CaseDataToAgencyFileMapper.INSTANCE.transform(exchange.getIn().getBody(CourtCaseData.class));
        LOG.info(agencyFile);
        exchange.getIn().setBody(agencyFile);
    }

}