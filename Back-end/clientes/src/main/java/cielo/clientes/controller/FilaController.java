package cielo.clientes.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import cielo.clientes.infra.fila.Fila;

@RestController
@RequestMapping("fila")
public class FilaController {

    @Autowired
    private Fila<Object> fila;

    @PostMapping("/adicionar")
    public void enqueue(@RequestBody Object item) {
        fila.adicionar(item);
    }


    @GetMapping("/vazia")
    public ResponseEntity vazia() {
        if( fila.vazia()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Fila Vazia!");
        }else{
            return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("Ainda existem usuários na fila!");
        }

    }

    @GetMapping("/tamanho")
    public int tamanho() {
        return fila.tamanho();
    }
    @GetMapping("/retirar")
    public Object retirar() {
        return fila.retirar();
    }


    @GetMapping
    public Object fila() {
        return fila.getFila();
    }




}
