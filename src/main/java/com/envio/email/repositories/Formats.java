package com.envio.email.repositories;

import com.envio.email.dtos.ProcessoDTO;
import com.envio.email.models.Companies;
import com.envio.email.models.Processo;

import java.util.List;

public interface Formats {
    String formatToHtml(Companies company, Processo processo , List<ProcessoDTO> processoDTOList);

}
