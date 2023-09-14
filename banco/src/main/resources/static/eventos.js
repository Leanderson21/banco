
    // Adicione um evento de escuta ao campo de entrada
    document.getElementById("nome").addEventListener("input", function () {
        // Capitalize a primeira letra de cada palavra
        this.value = this.value
            .toLowerCase() // Certifique-se de que todas as letras estejam em minúsculas
            .split(' ')
            .map(word => word.charAt(0).toUpperCase() + word.slice(1))
            .join(' ');
    });
    
  // Função para formatar o CPF
  function formatCPF(cpf) {
    cpf = cpf.replace(/\D/g, ''); // Remove todos os caracteres não numéricos
    cpf = cpf.slice(0, 11); 
    cpf = cpf.replace(/(\d{3})(\d)/, '$1.$2'); // Adiciona o primeiro ponto
    cpf = cpf.replace(/(\d{3})(\d)/, '$1.$2'); // Adiciona o segundo ponto
    cpf = cpf.replace(/(\d{3})(\d{1,2})$/, '$1-$2'); // Adiciona o traço
    return cpf;
  }

  // Event listener para formatar o CPF enquanto o usuário digita
  document.addEventListener('DOMContentLoaded', function () {
    var cpfInput = document.getElementById('cpf');

    cpfInput.addEventListener('input', function () {
      this.value = formatCPF(this.value);
    });
  });




