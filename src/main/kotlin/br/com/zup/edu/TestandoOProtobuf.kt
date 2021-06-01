package br.com.zup.edu

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val request = FuncionarioRequest.newBuilder()
        .setNome("Priscila")
        .setCpf("123.456.789-10")
        .setSalario(15000.20)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(
            FuncionarioRequest.Endereco.newBuilder()
                .setLogradouro("Rua Um")
                .setCep("11579-190")
                .setComplemento("ap 1")
                .build()
        )
        .build()

    // escrevemos o objeto
    println(request)
    request.writeTo(FileOutputStream("funcionario-request.bin"))

    // lemos o objeto
    val request2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))

    request2.setCargo(Cargo.GERENTE).build()
    println(request2)
}
