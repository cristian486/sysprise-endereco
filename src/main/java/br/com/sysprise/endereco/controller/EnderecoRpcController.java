package br.com.sysprise.endereco.controller;

import br.com.sysprise.endereco.service.EnderecoService;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import pb.CriarEnderecoRequest;
import pb.Endereco;
import pb.EnderecoId;
import pb.EnderecoServiceGrpc;

@GrpcService
@AllArgsConstructor
public class EnderecoRpcController extends EnderecoServiceGrpc.EnderecoServiceImplBase {

    private final EnderecoService enderecoService;

    @Override
    public void createEndereco(CriarEnderecoRequest request, StreamObserver<EnderecoId> responseObserver) {
        Long id = enderecoService.cadastrar(request);
        EnderecoId enderecoId = EnderecoId.newBuilder().setId(id).build();
        responseObserver.onNext(enderecoId);
        responseObserver.onCompleted();
    }

    @Override
    public void getEnderecoById(EnderecoId request, StreamObserver<Endereco> responseObserver) {
        Endereco endereco = enderecoService.getEnderecoRpcById(request.getId());
        responseObserver.onNext(endereco);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteEnderecoById(EnderecoId request, StreamObserver<pb.blank> responseObserver) {
        enderecoService.deletar(request.getId());
        responseObserver.onNext(pb.blank.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateEndereco(Endereco request, StreamObserver<pb.blank> responseObserver) {
        enderecoService.atualizar(request);
        responseObserver.onNext(pb.blank.newBuilder().build());
        responseObserver.onCompleted();
    }
}