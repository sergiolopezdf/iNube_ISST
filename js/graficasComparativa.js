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



var productosCompetencia = new CanvasJS.Chart('productosCompetencia', {
  //theme: 'light2',
  animationEnabled: true,
  title: {
    text: 'Productos respecto de la competencia',
    fontFamily: 'Catamaran',
  },
  axisY: {
    includeZero: true,
    title: 'Consumidos',
    fontFamily: 'Catamaran',
    suffix: '',
  },
  toolTip: {
    shared: 'true',
  },
  legend: {
    cursor: 'pointer',
    itemclick: toggleDataSeries,
  },
  data: [
    {
      type: 'spline',
      visible: false,
      showInLegend: true,
      yValueFormatString: '##',
      name: 'Menú del día',
      dataPoints: [
        {label: '1h', y: 0},
        {label: '2h', y: 0},
        {label: '3h', y: 0},
        {label: '4h', y: 0},
        {label: '5h', y: 0},
        {label: '6h', y: 0},
        {label: '7h', y: 0},
        {label: '8h', y: 0},
        {label: '9h', y: 0},
        {label: '10h', y: 0},
        {label: '11h', y: 0},
        {label: '12h', y: 3},
        {label: '13h', y: 12},
        {label: '14h', y: 28},
        {label: '15h', y: 25},
        {label: '16h', y: 8},
        {label: '17h', y: 0},
        {label: '18h', y: 0},
        {label: '19h', y: 0},
        {label: '20h', y: 0},
        {label: '21h', y: 0},
        {label: '22h', y: 0},
        {label: '23h', y: 0},
        {label: '24h', y: 0},
      ],
    },
    {
      type: 'spline',
      showInLegend: true,
      visible: false,
      yValueFormatString: '##',
      name: 'Ensaladas',
      dataPoints: [
        {label: '1h', y: 0},
        {label: '2h', y: 0},
        {label: '3h', y: 0},
        {label: '4h', y: 0},
        {label: '5h', y: 0},
        {label: '6h', y: 0},
        {label: '7h', y: 0},
        {label: '8h', y: 0},
        {label: '9h', y: 0},
        {label: '10h', y: 0},
        {label: '11h', y: 0},
        {label: '12h', y: 6},
        {label: '13h', y: 12},
        {label: '14h', y: 19},
        {label: '15h', y: 20},
        {label: '16h', y: 2},
        {label: '17h', y: 0},
        {label: '18h', y: 0},
        {label: '19h', y: 0},
        {label: '20h', y: 2},
        {label: '21h', y: 9},
        {label: '22h', y: 15},
        {label: '23h', y: 8},
        {label: '24h', y: 0},
      ],
    },
    {
      type: 'spline',
      showInLegend: true,
      yValueFormatString: '##',
      name: 'Carnes',
      dataPoints: [
        {label: '1h', y: 0},
        {label: '2h', y: 0},
        {label: '3h', y: 0},
        {label: '4h', y: 0},
        {label: '5h', y: 0},
        {label: '6h', y: 0},
        {label: '7h', y: 0},
        {label: '8h', y: 0},
        {label: '9h', y: 0},
        {label: '10h', y: 0},
        {label: '11h', y: 0},
        {label: '12h', y: 3},
        {label: '13h', y: 15},
        {label: '14h', y: 26},
        {label: '15h', y: 17},
        {label: '16h', y: 0},
        {label: '17h', y: 0},
        {label: '18h', y: 0},
        {label: '19h', y: 0},
        {label: '20h', y: 2},
        {label: '21h', y: 15},
        {label: '22h', y: 10},
        {label: '23h', y: 2},
        {label: '24h', y: 0},
      ],
    },
    {
      type: 'spline',
      showInLegend: true,
      yValueFormatString: '##',
      name: 'Pescados',
      dataPoints: [
        {label: '1h', y: 0},
        {label: '2h', y: 0},
        {label: '3h', y: 0},
        {label: '4h', y: 0},
        {label: '5h', y: 0},
        {label: '6h', y: 0},
        {label: '7h', y: 0},
        {label: '8h', y: 0},
        {label: '9h', y: 0},
        {label: '10h', y: 0},
        {label: '11h', y: 0},
        {label: '12h', y: 0},
        {label: '13h', y: 2},
        {label: '14h', y: 8},
        {label: '15h', y: 6},
        {label: '16h', y: 5},
        {label: '17h', y: 0},
        {label: '18h', y: 0},
        {label: '19h', y: 0},
        {label: '20h', y: 6},
        {label: '21h', y: 10},
        {label: '22h', y: 15},
        {label: '23h', y: 2},
        {label: '24h', y: 0},
      ],
    },
    {
      type: 'spline',
      showInLegend: true,
      yValueFormatString: '##',
      name: 'Postres y/o Café',
      dataPoints: [
        {label: '1h', y: 0},
        {label: '2h', y: 0},
        {label: '3h', y: 0},
        {label: '4h', y: 0},
        {label: '5h', y: 0},
        {label: '6h', y: 0},
        {label: '7h', y: 6},
        {label: '8h', y: 10},
        {label: '9h', y: 12},
        {label: '10h', y: 15},
        {label: '11h', y: 4},
        {label: '12h', y: 4},
        {label: '13h', y: 3},
        {label: '14h', y: 15},
        {label: '15h', y: 20},
        {label: '16h', y: 24},
        {label: '17h', y: 10},
        {label: '18h', y: 10},
        {label: '19h', y: 9},
        {label: '20h', y: 3},
        {label: '21h', y: 4},
        {label: '22h', y: 8},
        {label: '23h', y: 10},
        {label: '24h', y: 2},
      ],
    },
  ],
});


productosCompetencia.render();
function toggleDataSeries(e) {
  if (typeof(e.dataSeries.visible) === 'undefined' || e.dataSeries.visible) {
    e.dataSeries.visible = false;
  } else {
    e.dataSeries.visible = true;
  }
  productosCompetencia.render();
}


var ocupacionCompetencia = new CanvasJS.Chart("ocupacionCompetencia", {
  animationEnabled: true,
  title:{
    text: "Ocupación con respecto a la competencia",
    fontFamily: 'Catamaran',
  },
  axisY: {
    title: "Ocupación %",
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
      { label: "7h", y: 6 },
      { label: "8h", y: 7 },
      { label: "9h", y: 9 },
      { label: "10h", y: 7 },
      { label: "11h", y: 7 },
      { label: "12h", y: 3 },
      { label: "13h", y: 20 },
      { label: "14h", y: 28 },
      { label: "15h", y: 30 },
      { label: "16h", y: 10 },
      { label: "17h", y: 6 },
      { label: "18h", y: 8 },
      { label: "19h", y: 7 },
      { label: "20h", y: 10 },
      { label: "21h", y: 30 },
      { label: "22h", y: 20 },
      { label: "23h", y: 15 },
      { label: "24h", y: 0 }
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
        { label: "7h", y: 6 },
        { label: "8h", y: 10 },
        { label: "9h", y: 12 },
        { label: "10h", y: 15 },
        { label: "11h", y: 4 },
        { label: "12h", y: 4 },
        { label: "13h", y: 3 },
        { label: "14h", y: 15 },
        { label: "15h", y: 20 },
        { label: "16h", y: 24 },
        { label: "17h", y: 10 },
        { label: "18h", y: 10 },
        { label: "19h", y: 9 },
        { label: "20h", y: 3 },
        { label: "21h", y: 4 },
        { label: "22h", y: 8 },
        { label: "23h", y: 10 },
        { label: "24h", y: 2 }
      ]
    }]
});
ocupacionCompetencia.render();

function toggleDataSeries(e) {
  if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
    e.dataSeries.visible = false;
  }
  else {
    e.dataSeries.visible = true;
  }
  ocupacionCompetencia.render();
}
