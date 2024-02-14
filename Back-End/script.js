const formulario = document.querySelector('form')
const Inome = document.querySelector('.nome')
const Iemail = document.querySelector('.email')
const Isenha = document.querySelector('.senha')
const Iconfirmarsenha = document.querySelector('.confirmarsenha')

// Conexão com banco de dados para o cadastro

function cadastrar (){
        fetch('http://localhost:8080/usuarios',
        {
            headers: { 
                'Accept': 'aplication/json',
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body: JSON.stringify({
                nome: Inome.value,
                email: Iemail.value,
                senha: Isenha.value,
                confirmarsenha: Iconfirmarsenha.value
            })
        })
        .then(function(res){ console.log(res) })
        .catch(function(res){ console.log(res) })
}

// Função para limpar os dados preenchidos

function limpar (){
    Inome.value = "";
    Iemail.value = "";
    Isenha.value = "";
    Iconfirmarsenha.value = "";
};

formulario.addEventListener('submit', function (event){
    event.preventDefault();
    
    cadastrar();
    limpar();

});