var ingresosCompetencia = new CanvasJS.Chart("ingresosCompetencia", {
  animationEnabled: true,
  title:{
    text: "Ingresos con respecto a la competencia",
    fontFamily: 'Catamaran',
  },
  axisY: {
    title: "Ingresos €",
    titleFontColor: "black",
    lineColor: "black",
    labelFontColor: "black",
    tickColor: "black"
  },
  toolTip: {
    shared: true
  },
  legend: {
    cursor:"pointer",
    itemclick: toggleDataSeries
  },
  data: [{
    type: "column",
    name: "Tu Restaurante",
    legendText: "Tu Restaurante",
    showInLegend: true,
    dataPoints:[
      { label: "1h", y: 0 },
      { label: "2h", y: 0 },
      { label: "3h", y: 0 },
      { label: "4h", y: 0 },
      { label: "5h", y: 0 },
      { label: "6h", y: 0 },
      { label: "7h", y: 7.56 },
      { label: "8h", y: 15.6 },
      { label: "9h", y: 16 },
      { label: "10h", y: 25.1 },
      { label: "11h", y: 6.4 },
      { label: "12h", y: 9.7 },
      { label: "13h", y: 260.4 },
      { label: "14h", y: 400.5 },
      { label: "15h", y: 620 },
      { label: "16h", y: 240 },
      { label: "17h", y: 21.6 },
      { label: "18h", y: 14.1 },
      { label: "19h", y: 9.6 },
      { label: "20h", y: 70.6 },
      { label: "21h", y: 201.3 },
      { label: "22h", y: 400.4 },
      { label: "23h", y: 100 },
      { label: "24h", y: 10 }
    ]
  },
    {
      type: "column",
      name: "Compentencia",
      legendText: "Competencia",
      showInLegend: true,
      dataPoints:[
        { label: "1h", y: 0 },
        { label: "2h", y: 0 },
        { label: "3h", y: 0 },
        { label: "4h", y: 0 },
        { label: "5h", y: 0 },
        { label: "6h", y: 0 },
        { label: "7h", y: 9.87 },
        { label: "8h", y: 20.78 },
        { label: "9h", y: 14 },
        { label: "10h", y: 45 },
        { label: "11h", y: 52 },
        { label: "12h", y: 56 },
        { label: "13h", y: 300 },
        { label: "14h", y: 320 },
        { label: "15h", y: 569 },
        { label: "16h", y: 210 },
        { label: "17h", y: 30.4 },
        { label: "18h", y: 12 },
        { label: "19h", y: 10.6 },
        { label: "20h", y: 80.6 },
        { label: "21h", y: 101.3 },
        { label: "22h", y: 450.4 },
        { label: "23h", y: 90 },
        { label: "24h", y: 20 }
      ]
    }]
});
ingresosCompetencia.render();

function toggleDataSeries(e) {
  if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
    e.dataSeries.visible = false;
  }
  else {
    e.dataSeries.visible = true;
  }
  ingresosCompetencia.render();
}

