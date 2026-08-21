# My Virtual PC — Android 32-bit Gaming

Projeto experimental para criar um ambiente Android otimizado para aparelhos **Android 32-bit (ARMv7 / armeabi-v7a)**, com foco em executar jogos compatíveis com 32-bit.

## Objetivo principal
Executar jogos Android no próprio aparelho, priorizando baixo consumo de RAM, estabilidade e desempenho gráfico.

Jogos-alvo para testes de compatibilidade:
- Avatar World
- Minecraft
- Brawl Stars

O projeto não inclui APKs, arquivos de jogos ou recursos proprietários. O usuário deve fornecer apenas software que tenha direito de utilizar.

## Estratégia técnica
Uma VM Android completa pode ter desempenho ruim em celulares 32-bit. Por isso, o projeto deve priorizar uma camada nativa/compatibility layer sempre que possível e usar virtualização apenas quando houver suporte real do hardware.

### Requisitos do runtime
- Arquitetura principal: ARM 32-bit / armeabi-v7a.
- Evitar dependências que exijam processo 64-bit.
- Renderização acelerada por GPU quando disponível.
- OpenGL ES/Vulkan somente conforme suporte real do aparelho.
- Controle de memória para aparelhos com pouca RAM.
- Limite configurável de resolução e FPS.
- Controles touch nativos.
- Teclado e mouse como opções adicionais.
- Perfis individuais de configuração para cada jogo.
- Logs e diagnóstico de compatibilidade.

## Perfis iniciais

### Avatar World
Perfil de baixo consumo, resolução adaptativa e limite de FPS configurável.

### Minecraft
Perfil com distância de renderização ajustável, limite de FPS e controle de memória.

### Brawl Stars
Perfil priorizando baixa latência, estabilidade de FPS e controles touch.

## Limitações importantes
Um aplicativo Android 32-bit não consegue magicamente transformar o sistema inteiro em 64-bit. O objetivo é executar software 32-bit de forma eficiente. Se um jogo exigir obrigatoriamente componentes 64-bit em uma versão futura, ele poderá deixar de funcionar neste aparelho.

## Próximas etapas
1. Criar o aplicativo Android ARMv7.
2. Detectar CPU, RAM, GPU e APIs gráficas disponíveis.
3. Criar o launcher e os perfis de jogos.
4. Implementar a camada de execução compatível com 32-bit.
5. Adicionar controles e configurações de desempenho.
6. Criar diagnóstico para identificar por que um jogo não inicia.
7. Gerar APK de teste ARMv7.
