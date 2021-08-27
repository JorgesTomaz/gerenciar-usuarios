$(function(){
    'use strict';
    
    if($('.telefone').length > 0){
        $('.telefone').mask(`(00) 0 0000-0000`);
    }

    if($('.cpf').length > 0){
        $('.cpf').mask('000.000.000-00', {reverse: true});
    }

    if($('.input-litros').length > 0){
        $('.input-litros').mask('000.000.000', {reverse: true});
    }
    console.log("script carregado");
});

function deletaLinha(linha){
	console.log(linha);
	$("#"+linha).remove();
}