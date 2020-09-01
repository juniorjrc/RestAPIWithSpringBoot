package br.com.jrcsofthouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.jrcsofthouse.converter.DozerConverter;
import br.com.jrcsofthouse.data.model.Book;
import br.com.jrcsofthouse.data.vo.v1.BookVO;
import br.com.jrcsofthouse.exception.ResourceNotFoundException;
import br.com.jrcsofthouse.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	
	//BUSCA TODOS OS LIVROS
	public Page<BookVO> findAll(Pageable pageable){
		var page = repository.findAll(pageable);
		return page.map(this::convertToBookVO);
	}
	
	private BookVO convertToBookVO(Book entity) {
		return DozerConverter.parseObject(entity, BookVO.class);
	}
	
	//BUSCA UM LIVRO POR ID
	public BookVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		return DozerConverter.parseObject(repository.save(entity), BookVO.class);
	}
	
	//CRIA UM LIVRO NA BASE
	public BookVO create(BookVO book) {
		var entity = DozerConverter.parseObject(book, Book.class);
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	
	//ATUALIZA UM LIVRO NA BASE
	public BookVO update(BookVO book) {
		var entity = repository.findById(book.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setName(book.getName());
		entity.setDescription(book.getDescription());

		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	
	//DELETA UM LIVRO DA BASE
	public void delete(Long id) {
		Book entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
	}

}
