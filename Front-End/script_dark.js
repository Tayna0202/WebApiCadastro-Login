let trilho = document.getElementById('trilho')
let box = document.querySelector('.box')
let button = document.querySelector('button')
let body = document.querySelector('body')

trilho.addEventListener('click', ()=>{
    trilho.classList.toggle('dark')
    box.classList.toggle('dark')
    button.classList.toggle('dark')
    body.classList.toggle('dark')
})