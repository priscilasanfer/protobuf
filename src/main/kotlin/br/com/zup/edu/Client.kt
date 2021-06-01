package br.com.zup.edu

import io.grpc.ManagedChannelBuilder

fun main(){
    val channel  = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    val request = FuncionarioRequest.newBuilder()
        .setNome("Priscila")
        .setCpf("123.456.789-10")
        .setSalario(15000.20)
        .setIdade(35)
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

    val client = FuncionarioServiceGrpc.newBlockingStub(channel)
    val response = client.cadastrar(request)

    println(response)
}