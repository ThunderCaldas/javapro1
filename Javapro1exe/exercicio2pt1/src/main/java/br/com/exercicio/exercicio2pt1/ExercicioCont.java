package br.com.exercicio.exercicio2pt1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Controlador")
public class ExercicioCont {

    private final List<DadosCont> dadosconta;

    public ExercicioCont() {
    this.dadosconta = new ArrayList<>();
    DadosCont d1 = new DadosCont(1,"Rosa",12);
    DadosCont d2 = new DadosCont(2,"Maria",13);
    DadosCont d3 = new DadosCont(3,"João",12);
    DadosCont d4 = new DadosCont(4,"Lucas",11);
    DadosCont d5 = new DadosCont(5,"Gabriel",12);
    this.dadosconta.add(d1);
    this.dadosconta.add(d2);
    this.dadosconta.add(d3);
    this.dadosconta.add(d4);
    this.dadosconta.add(d5);
    }

    @GetMapping
    public List<DadosCont> localizar(@RequestParam(required = false) String nomealuno, Integer idadealuno) {
        if (nomealuno != null) {
            return dadosconta.stream()
                    .filter(msg -> msg.getNome().contains(nomealuno))
                    .collect(Collectors.toList());
        } if(idadealuno != null){
            return dadosconta.stream()
                    .filter(msg -> msg.getIdade().equals(idadealuno))
                    .collect(Collectors.toList());}
        return dadosconta;
    }

    @GetMapping("/id{id}")
    public List<DadosCont> localizaId(@PathVariable("id")Integer id) {
                    return dadosconta.stream()
                    .filter(msg -> msg.getId().equals(id))
                    .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){
        dadosconta.removeIf(msg -> msg.getId().equals(id));
    }

    @PutMapping
    public void att(@RequestBody final DadosCont dadosCont){
        dadosconta.stream()
                .filter(msg -> msg.getId().equals(dadosCont.getId()))
                .forEach(msg -> msg.setNome(dadosCont.getNome()));
    }

    @PostMapping
    public Integer add(@RequestBody final DadosCont dadosCont){
        if(dadosCont.getId() == null){
           dadosCont.setId(dadosconta.size() +1);
        }
        dadosconta.add(dadosCont);
        return dadosCont.getId();
    }

}




