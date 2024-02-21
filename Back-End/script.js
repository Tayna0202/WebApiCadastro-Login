const formulario = document.querySelector('form')
const Inome = document.querySelector('.nome')
const Iemail = document.querySelector('.email')
const Isenha = document.querySelector('.senha')
const Iconfirmarsenha = document.querySelector('.confirmarsenha')

const LoginEmail = document.querySelector('.LoginEmail')
const LoginSenha = document.querySelector('.LoginSenha')

// Conexão com banco de dados para o cadastro

function cadastrar (){
        date = fetch('http://localhost:8080/usuarios',
        {
            headers: { 
                'Accept': 'aplication/json',
                'Content-Type': 'application/json',
            },
            method: 'POST',
            body: JSON.stringify({
                nome: Inome.value,
                email: Iemail.value,
                senha: Isenha.value,
                confirmarsenha: Iconfirmarsenha.value,
            })
        })
        .then(res=>res.json())
        .then(date=>{
                console.log(date)
        })
        .then(function(res){ console.log(res) })
        .catch(function(res){ console.log(res) })
        console.log(date)
        alert("Usuário Cadastrado com sucesso!")
}

function login (){
        date = fetch('http://localhost:8080/usuarios/login',
        {
            headers: { 
                'Accept': 'aplication/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' 
            },
            method: 'POST',
            body: JSON.stringify({
                nome: Inome.value,
                email: Iemail.value,
                senha: Isenha.value,
            })
        })
        .then(res=>res.json())
        .then(date=>{
                console.log(date)
        })
        .then(function(res){ console.log(res) })
        .catch(function(res){ console.log(res) })
        console.log(date)
}

function logout(){
    window.location.href = "login.html"
}

function recuperar_senha(){
    window.location.href = "recuperar_senha.html"
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
