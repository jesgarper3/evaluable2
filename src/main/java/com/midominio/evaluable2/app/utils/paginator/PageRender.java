package com.midominio.evaluable2.app.utils.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender <T>{
	
	private String url;
	private Page<T> page;
	
	private int totalPaginas;
	private int numPaginasAMostrar;
	private int paginaActual;
	
	private List<PageItem> paginas;

	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<PageItem>();
		numPaginasAMostrar = 5;
		totalPaginas = page.getTotalPages();
		paginaActual = page.getNumber() + 1;
		
		int desde, hasta;
		
		if (totalPaginas <= numPaginasAMostrar) {
			desde = 1;
			hasta = totalPaginas;	
		} else {
			if (paginaActual <= numPaginasAMostrar / 2) {
				desde = 1;
				hasta = numPaginasAMostrar;
			} else if (paginaActual >= totalPaginas - numPaginasAMostrar / 2) {
				desde = totalPaginas - numPaginasAMostrar + 1;
				hasta = numPaginasAMostrar;
			} else {
				desde = paginaActual - numPaginasAMostrar / 2;
				hasta = numPaginasAMostrar;
			}
		}
		for (int i = 0; i < hasta; i++) {
			paginas.add(new PageItem(desde + i, paginaActual == desde + i));
		}
	}

	public String getUrl() {
		return url;
	}

	public Page<T> getPage() {
		return page;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public int getNumPaginasAMostrar() {
		return numPaginasAMostrar;
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public List<PageItem> getPaginas() {
		return paginas;
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}

	public boolean isLast() {
		return page.isLast();
	}

	public boolean isHasNext() {

		return page.hasNext();
	}

	public boolean isHasPrevious() {
		return page.hasPrevious();

	}
}
