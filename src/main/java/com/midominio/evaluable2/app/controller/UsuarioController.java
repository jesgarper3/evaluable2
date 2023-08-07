package com.midominio.evaluable2.app.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.midominio.evaluable2.app.model.entity.Usuario;
import com.midominio.evaluable2.app.service.IUsuarioService;
import com.midominio.evaluable2.app.utils.paginator.PageRender;

import jakarta.validation.Valid;

@RequestMapping("/usuario")
@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/listar")
	public String listado(@RequestParam(defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Usuario> usuarios = usuarioService.listar(pageRequest);
		PageRender<Usuario> pageRender = new PageRender<>("/usuario/listar", usuarios);
		model.addAttribute("titulo", "Listado de Usuarios");
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("page", pageRender);
		
		return "usuario/listar";
	}

	@GetMapping("/form")
	public String alta(Map<String, Object> model) {
		model.put("titulo", "Formulario de Usuario");
		model.put("usuario", new Usuario());

		return "usuario/form";
	}

	@PostMapping("/form")
	public String guardar(@Valid Usuario usuario, 
			BindingResult result,
			@RequestParam("file") MultipartFile foto,
			Model model, RedirectAttributes flash) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Edición de un Usuario");
			
			return "usuario/form";
		}
		if (!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src/main/resources/static/upload");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "/" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				flash.addFlashAttribute("info", "Subido correctamente " + foto.getOriginalFilename());
				usuario.setFoto(foto.getOriginalFilename());
			} catch (Exception e) {

			}
		}
		usuarioService.save(usuario);
		flash.addFlashAttribute("success", "Usuario guardado con éxito");

		return "redirect:listar";
	}
	
	@GetMapping("/ver/{id}")
	public String verPorId(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, Model model,
			RedirectAttributes flash) {

		Usuario usuario = usuarioService.findOne(id);

		if (usuario == null) {
			flash.addFlashAttribute("error", "Usuario inexistente");
			return "redirect:/usuario/listar";
		}

		model.addAttribute("titulo", "Mostrando un Usuario");
		model.addAttribute("usuario", usuario);

		return "usuario/ver";
	}

	@GetMapping("/form/{id}")
	public String modificacion(@PathVariable("id") Long id, Map<String, Object> model) {
		Usuario usuario = null;
		if (id > 0) {
			usuario = usuarioService.findOne(id);
			if (usuario == null)
				return "redirect:/usuario/listar";
		} else {
			return "redirect:/usuario/listar";
		}
		model.put("usuario", usuario);
		model.put("titulo", "Editar Usuario");

		return "usuario/form";
	}

	@GetMapping("/eliminar/{id}")
	public String baja(@PathVariable("id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			usuarioService.delete(id);
			flash.addFlashAttribute("warningDelete", "Usuario eliminado con éxito");
		}
		return "redirect:/usuario/listar";

	}
}
