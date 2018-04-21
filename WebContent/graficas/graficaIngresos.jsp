var ingresos = new CanvasJS.Chart("ingresos", {
  animationEnabled: true,
  //theme: "light2", // "light1", "light2", "dark1", "dark2"
  title:{
    text: "Ingresos",
    fontFamily: 'Catamaran',
  },
  axisY: {
    title: "Ingresos (euros)",
    fontFamily: 'Catamaran',
  },
  data: [{
    type: "column",
    dataPoints: [
     
      ${dataIngresos}
      
    ]
  }]
});
ingresos.render();







