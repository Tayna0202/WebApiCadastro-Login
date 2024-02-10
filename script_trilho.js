let trilho = document.getElementById('trilho')
let box = document.querySelector('.box')
let button = document.querySelector('button')

trilho.addEventListener('click', ()=>{
    trilho.classList.toggle('dark')
    box.classList.toggle('dark')
    button.classList.toggle('dark')
})