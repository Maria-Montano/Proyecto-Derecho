window.addEventListener('scroll', () => {
    const navbar = document.getElementById('navbar');
    const carrusel = document.querySelector('.carrusel');
  
    const carruselRect = carrusel.getBoundingClientRect();
    const carruselBottom = carruselRect.bottom;
  
    if (window.scrollY >= carruselBottom) {
      navbar.style.position = 'fixed';
      navbar.style.width= '90%';
      navbar.style.color= 'black';
    }else{
      navbar.style.position = 'initial';
    }
  });
  