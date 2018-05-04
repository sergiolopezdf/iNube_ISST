var ocupacion = new CanvasJS.Chart("ocupacion", {
  animationEnabled: true,
  theme: "light1", // "light1", "light2", "dark1", "dark2"
  title:{
    text: "Ocupaci�n",
    fontFamily: 'Catamaran',
  },
  axisY: {
    title: "Ocupacion (n�mero de transacciones)"
  },
  data: [{
    type: "column",
    dataPoints:[
       ${dataOcupacion}
    ]
  }]
});


ocupacion.render();
function toggleDataSeries(e) {
  if (typeof(e.dataSeries.visible) === 'undefined' || e.dataSeries.visible) {
    e.dataSeries.visible = false;
  }
  else {
    e.dataSeries.visible = true;
  }
  ocupacion.render();
}
