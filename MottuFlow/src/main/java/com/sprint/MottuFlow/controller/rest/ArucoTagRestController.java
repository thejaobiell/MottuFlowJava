package com.sprint.MottuFlow.controller.rest;

import com.sprint.MottuFlow.domain.arucotag.ArucoTagDTO;
import com.sprint.MottuFlow.domain.arucotag.ArucoTag;
import com.sprint.MottuFlow.domain.moto.Moto;
import com.sprint.MottuFlow.domain.arucotag.ArucoTagService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/aruco-tags")
public class ArucoTagRestController {

    private final ArucoTagService atS;
	
	public ArucoTagRestController( ArucoTagService atS ) {
		this.atS = atS;
	}
	
	private ArucoTagDTO convertToDTO(ArucoTag tag) {
        return new ArucoTagDTO(
                tag.getIdTag(),
                tag.getCodigo(),
                tag.getMoto().getIdMoto(),
                tag.getStatus()
        );
    }

    private ArucoTag convertToEntity(ArucoTagDTO dto) {
        ArucoTag tag = new ArucoTag();
        tag.setIdTag(dto.getIdTag());
        tag.setCodigo(dto.getCodigo());

        if (dto.getIdMoto() != 0) {
            Moto moto = new Moto();
            moto.setIdMoto(dto.getIdMoto());
            tag.setMoto(moto);
        }
        tag.setStatus(dto.getStatus());
        return tag;
    }

    @GetMapping
    public List<ArucoTagDTO> getAll() {
        List<ArucoTag> tags = atS.listarArucoTags();
        return tags.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ArucoTagDTO> getById(@PathVariable Long id) {
        ArucoTag tag = atS.buscarTagPorId(id);
        return ResponseEntity.ok(convertToDTO(tag));
    }
    
    @GetMapping("/status/{status}")
    public List<ArucoTagDTO> getByStatus(@PathVariable String status) {
        List<ArucoTag> tags = atS.buscarPorStatus(status);
        return tags.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<ArucoTagDTO> getByCodigo(@PathVariable String codigo) {
        ArucoTag tag = atS.buscarPorCodigo(codigo);
        return ResponseEntity.ok(convertToDTO(tag));
    }


    @PostMapping
    public ResponseEntity<ArucoTagDTO> create(@RequestBody @Valid ArucoTagDTO tagDTO) {
        ArucoTag tag = convertToEntity(tagDTO);
        ArucoTag saved = atS.cadastrarTag(tag);
        return ResponseEntity.ok(convertToDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArucoTagDTO> update(@PathVariable Long id, @RequestBody ArucoTagDTO tagDTO) {
        ArucoTag tagDetails = convertToEntity(tagDTO);
        ArucoTag updated = atS.editarTag(id, tagDetails);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        atS.deletarTag(id);
        return ResponseEntity.noContent().build();
    }
}
