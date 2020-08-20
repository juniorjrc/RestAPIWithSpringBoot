package br.com.jrcsofthouse.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jrcsofthouse.exception.UnsuportedDivisionByZero;
import br.com.jrcsofthouse.exception.UnsuportedMathOperationException;
import br.com.jrcsofthouse.math.SimpleMath;
import br.com.jrcsofthouse.request.converters.NumberConverter;

@RestController
public class MathController {
	
	private SimpleMath math = new SimpleMath();
	
	//SOMA
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)	
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.sum(NumberConverter.converToDouble(numberOne), NumberConverter.converToDouble(numberTwo));
	}
	
	//SUBTRAÇÃO
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)	
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.sub(NumberConverter.converToDouble(numberOne), NumberConverter.converToDouble(numberTwo));
	}
	
	//MULTIPLICAÇÃO
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)	
	public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.mult(NumberConverter.converToDouble(numberOne), NumberConverter.converToDouble(numberTwo));
	}
	
	//DIVISÃO
	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)	
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		if(numberTwo.equals("0"))
			throw new UnsuportedDivisionByZero("Unsuported division by zero!");
	
		return math.div(NumberConverter.converToDouble(numberOne), NumberConverter.converToDouble(numberTwo));
	}
	
	//MÉDIA
	@RequestMapping(value="/med/{numberOne}/{numberTwo}", method=RequestMethod.GET)	
	public Double med(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.media(NumberConverter.converToDouble(numberOne), NumberConverter.converToDouble(numberTwo));
	}
	
	//RAIZ QUADRADA
	@RequestMapping(value="/raiz/{numberOne}", method=RequestMethod.GET)	
	public Double raiz(@PathVariable("numberOne") String numberOne) throws Exception {
		if(!NumberConverter.isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.raiz(NumberConverter.converToDouble(numberOne));
	}

}
