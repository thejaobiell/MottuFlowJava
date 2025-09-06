package com.sprint.MottuFlow.controller.web;

import com.sprint.MottuFlow.domain.camera.Camera;
import com.sprint.MottuFlow.domain.camera.CameraService;
import com.sprint.MottuFlow.domain.patio.PatioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping( "/cameras" )
public class CameraWebController {
	
	private final CameraService cS;
	private final PatioService pS;
	
	public CameraWebController( CameraService cS, PatioService pS ) {
		this.cS = cS;
		this.pS = pS;
	}
	
	@GetMapping( "/listar" )
	public String listarCameras( Model model ) {
		model.addAttribute( "cameras", cS.listarCameras() );
		model.addAttribute( "patios", pS.listarPatios() );
		model.addAttribute( "novaCamera", new Camera() );
		return "cameras/listar";
	}
	
	@PostMapping( "/cadastrar" )
	public String cadastrarCamera( @ModelAttribute( "novaCamera" ) Camera camera ) {
		cS.cadastrarCamera( camera );
		return "redirect:/cameras/listar";
	}
	
	@GetMapping( "/editar/{id}" )
	public String editarCameraForm( @PathVariable Long id, Model model ) {
		Camera camera = cS.buscarCameraPorId( id );
		model.addAttribute( "camera", camera );
		model.addAttribute( "patios", pS.listarPatios() );
		return "cameras/editar";
	}
	
	@PostMapping( "/editar/{id}" )
	public String editarCamera( @PathVariable Long id, @ModelAttribute Camera cameraAtualizada ) {
		cS.editarCamera( id, cameraAtualizada );
		return "redirect:/cameras/listar";
	}
	
	@PostMapping( "/deletar/{id}" )
	public String deletarCamera( @PathVariable Long id ) {
		cS.deletarCamera( id );
		return "redirect:/cameras/listar";
	}
}
