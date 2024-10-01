package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.req.CreatePedidoDTO; // DTO for creating a new order
import com.example.demo.dtos.res.ShowClienteDTO; // DTO for displaying client information
import com.example.demo.dtos.res.ShowEnderecoDTO; // DTO for displaying address information
import com.example.demo.dtos.res.ShowPedidosDTO; // DTO for displaying order information
import com.example.demo.entities.ClienteEntity; // Entity representing a client
import com.example.demo.entities.EnderecoEntity; // Entity representing an address
import com.example.demo.entities.PedidoEntity; // Entity representing an order
import com.example.demo.repositories.PedidoRepository; // Repository for order persistence

@Service // This annotation indicates that this class is a service component in the Spring context
public class PedidoService {

    @Autowired // Automatically injects the PedidoRepository instance
    private PedidoRepository pedidoRepository;

    /**
     * Creates a new order based on the provided CreatePedidoDTO.
     * @param dto the DTO containing order creation information
     */
    public void createPedido(CreatePedidoDTO dto) {
        // Create a new instance of PedidoEntity to represent the order
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setProduto(dto.getProduto()); // Set the product from the DTO
        pedidoEntity.setQuantidade(dto.getQuantidade()); // Set the quantity from the DTO

        // Create a new instance of EnderecoEntity to represent the address
        EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setRua(dto.getEndereco().getRua()); // Set the street from the DTO
        enderecoEntity.setNumero(dto.getEndereco().getNumero()); // Set the number from the DTO
        enderecoEntity.setCidade(dto.getEndereco().getCidade()); // Set the city from the DTO

        // Associate the address with the order
        pedidoEntity.setEndereco(enderecoEntity); // Set the address for the order
        enderecoEntity.setPedido(pedidoEntity); // Link the order back to the address

        // Save the order in the repository; this also saves the address due to cascade
        pedidoRepository.save(pedidoEntity);
    }

    /**
     * Retrieves all orders and maps them to ShowPedidosDTO for response.
     * @return a list of ShowPedidosDTO representing all orders
     */
    public List<ShowPedidosDTO> getPedidos() {
        List<PedidoEntity> pedidosEntity = pedidoRepository.findAll(); // Fetch all orders from the repository

        return pedidosEntity.stream().map(pedido -> { // Stream through each order entity
            ShowPedidosDTO pedidoDTO = new ShowPedidosDTO(); // Create a new DTO for the order
            ShowEnderecoDTO enderecoDTO = new ShowEnderecoDTO(); // Create a new DTO for the address
            List<ShowClienteDTO> clientesDTO = new ArrayList<>(); // Create a list to hold client DTOs

            // Map clients from the order entity to the client DTOs
            for (ClienteEntity clienteEntity : pedido.getClientes()) {
                ShowClienteDTO clienteDTO = new ShowClienteDTO(); // Create a DTO for each client
                clienteDTO.setNome(clienteEntity.getNome()); // Set the client name from the entity
                clientesDTO.add(clienteDTO); // Add the client DTO to the list
            }

            // Map address from the order entity to the address DTO
            if (pedido.getEndereco() != null) { // Check if the order has an address
                enderecoDTO.setRua(pedido.getEndereco().getRua()); // Set the street
                enderecoDTO.setNumero(pedido.getEndereco().getNumero()); // Set the number
                enderecoDTO.setCidade(pedido.getEndereco().getCidade()); // Set the city
            }

            // Map the order entity properties to the order DTO
            pedidoDTO.setId(pedido.getId().toString()); // Convert the order ID to a string
            pedidoDTO.setProduto(pedido.getProduto()); // Set the product
            pedidoDTO.setQuantidade(pedido.getQuantidade()); // Set the quantity
            pedidoDTO.setClientes(clientesDTO); // Set the list of client DTOs
            pedidoDTO.setEndereco(enderecoDTO); // Set the address DTO

            return pedidoDTO; // Return the mapped order DTO
        }).toList(); // Collect the results into a list
    }
}
