# 99Tab
Teste de Desenvolvedor Android - 99

99Tab é um app desenvolvido baseado em requisitos de um desafio para concorrer a uma vaga de desenvolvedor Android na empresa 99.

#### O Desafio

1. Modele uma classe que represente o JSON a seguir, as datas estão formatadas em ISO8601.
2. Carregue esses dados a partir de um arquivo e exiba numa tabela, deixamos com você o layout da interface.
* Tivemos um problema durante o desenvolvimento do projeto, pois encontramos um bug na nossa API que teremos que resolver no lado do aplicativo.
3. A listagem de pessoas estava retornando dados duplicados, o que não deveria acontecer pois eles possuem um identificador único.
* Como podemos evitar a exibição repetida? Não exiba os dados duplicados na tabela, mostrando apenas uma das informações. Na 99 damos muito valor a qualidade de código.
4. Entregue o teste na linguagem que preferir e se sentir a necessidade de usar bibliotecas externas, não fique com vergonha, pois também usamos :)

______________________

Com base nos requisitos apresentados, foi desenvolvido um aplicativo com uma interface clean, funcional e intuitiva, que abrange tanto orientação de tela em retrato como em paisagem. 
Visando fazer um código bem sucinto e direto ao ponto, foi utilizado poucas libraries externas e poucas classes. 
Tratamento de possíveis registros em branco, foi implementado, além da eliminação de registros repetidos bem como está solicitado nos requisitos. Assim como alguns testes unitários e funcionais.
A interface foi desenvolvida visando atender a identidade visual da 99.

##### Possíveis próximos passos

1. Desenvolver a requisição da lista de uma API.
2. Compartilhamento entre apps das informações e fotos das pessoas listadas.
3. Prover a biografia em vários idiomas, por meio de uma tradução automática ou enviando o idioma na requisição para a API.