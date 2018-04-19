var ingresosCompetencia = new CanvasJS.Chart('ingresosCompetencia', {
  animationEnabled: true,
  title: {
    text: 'Ingresos con respecto a la competencia',
    fontFamily: 'Catamaran',
  },
  axisY: {
    title: 'Ingresos €',
    titleFontColor: 'black',
    lineColor: 'black',
    labelFontColor: 'black',
    tickColor: 'black',
  },
  toolTip: {
    shared: true,
  },
  legend: {
    cursor: 'pointer',
    itemclick: toggleDataSeries,
  },
  data: [
    {
      type: 'column',
      name: 'Tu Restaurante',
      legendText: 'Tu Restaurante',
      showInLegend: true,
      dataPoints: [
        {label: '1h', y: 0},
        {label: '2h', y: 0},
        {label: '3h', y: 0},
        {label: '4h', y: 0},
        {label: '5h', y: 0},
        {label: '6h', y: 0},
        {label: '7h', y: 7.56},
        {label: '8h', y: 15.6},
        {label: '9h', y: 16},
        {label: '10h', y: 25.1},
        {label: '11h', y: 6.4},
        {label: '12h', y: 9.7},
        {label: '13h', y: 260.4},
        {label: '14h', y: 400.5},
        {label: '15h', y: 620},
        {label: '16h', y: 240},
        {label: '17h', y: 21.6},
        {label: '18h', y: 14.1},
        {label: '19h', y: 9.6},
        {label: '20h', y: 70.6},
        {label: '21h', y: 201.3},
        {label: '22h', y: 400.4},
        {label: '23h', y: 100},
        {label: '24h', y: 10},
      ],
    },
    {
      type: 'column',
      name: 'Compentencia',
      legendText: 'Competencia',
      showInLegend: true,
      dataPoints: [
        {label: '1h', y: 0},
        {label: '2h', y: 0},
        {label: '3h', y: 0},
        {label: '4h', y: 0},
        {label: '5h', y: 0},
        {label: '6h', y: 0},
        {label: '7h', y: 9.87},
        {label: '8h', y: 20.78},
        {label: '9h', y: 14},
        {label: '10h', y: 45},
        {label: '11h', y: 52},
        {label: '12h', y: 56},
        {label: '13h', y: 300},
        {label: '14h', y: 320},
        {label: '15h', y: 569},
        {label: '16h', y: 210},
        {label: '17h', y: 30.4},
        {label: '18h', y: 12},
        {label: '19h', y: 10.6},
        {label: '20h', y: 80.6},
        {label: '21h', y: 101.3},
        {label: '22h', y: 450.4},
        {label: '23h', y: 90},
        {label: '24h', y: 20},
      ],
    }],
});
ingresosCompetencia.render();

function toggleDataSeries(e) {
  if (typeof(e.dataSeries.visible) === 'undefined' || e.dataSeries.visible) {
    e.dataSeries.visible = false;
  }
  else {
    e.dataSeries.visible = true;
  }
  ingresosCompetencia.render();
}

var ocupacionPostal = new CanvasJS.Chart('ocupacionPostal', {
  exportEnabled: false ,
  animationEnabled: true,
  title: {
    text: 'Ocupación del negocio según su procedencia',
    fontFamily: 'Catamaran',
  },
  legend: {
    cursor: 'pointer',
    itemclick: explodePie,
  },
  data: [
    {
      type: 'pie',
      showInLegend: true,
      toolTipContent: '{name}: <strong>{y}%</strong>',
      indexLabel: '{name} - {y}%',
      dataPoints: [
        {y: 30, name: '28029', exploded: true},
        {y: 15, name: '28035'},
        {y: 16, name: '28034'},
        {y: 10, name: '28039'},
        {y: 6, name: '28049'},
        {y: 11, name: '28023'},
        {y: 12, name: 'Otros codigos postales'},
      ],
    }],
});
ocupacionPostal.render();

function explodePie(e) {
  if (typeof (e.dataSeries.dataPoints[e.dataPointIndex].exploded) ===
      'undefined' || !e.dataSeries.dataPoints[e.dataPointIndex].exploded) {
    e.dataSeries.dataPoints[e.dataPointIndex].exploded = true;
  } else {
    e.dataSeries.dataPoints[e.dataPointIndex].exploded = false;
  }
  e.ocupacionPostal.render();
}

var ocupacionCompetencia = new CanvasJS.Chart('ocupacionCompetencia', {
  animationEnabled: true,
  title: {
    text: 'Ocupación con respecto a la competencia',
    fontFamily: 'Catamaran',
  },
  axisY: {
    title: 'Ocupación %',
    titleFontColor: 'black',
    lineColor: 'black',
    labelFontColor: 'black',
    tickColor: 'black',
  },
  toolTip: {
    shared: true,
  },
  legend: {
    cursor: 'pointer',
    itemclick: toggleDataSeries,
  },
  data: [
    {
      type: 'column',
      name: 'Tu Restaurante',
      legendText: 'Tu Restaurante',
      showInLegend: true,
      dataPoints: [
        {label: '1h', y: 0},
        {label: '2h', y: 0},
        {label: '3h', y: 0},
        {label: '4h', y: 0},
        {label: '5h', y: 0},
        {label: '6h', y: 0},
        {label: '7h', y: 6},
        {label: '8h', y: 7},
        {label: '9h', y: 9},
        {label: '10h', y: 7},
        {label: '11h', y: 7},
        {label: '12h', y: 3},
        {label: '13h', y: 20},
        {label: '14h', y: 28},
        {label: '15h', y: 30},
        {label: '16h', y: 10},
        {label: '17h', y: 6},
        {label: '18h', y: 8},
        {label: '19h', y: 7},
        {label: '20h', y: 10},
        {label: '21h', y: 30},
        {label: '22h', y: 20},
        {label: '23h', y: 15},
        {label: '24h', y: 0},
      ],
    },
    {
      type: 'column',
      name: 'Compentencia',
      legendText: 'Competencia',
      showInLegend: true,
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
    }],
});
ocupacionCompetencia.render();

function toggleDataSeries(e) {
  if (typeof(e.dataSeries.visible) === 'undefined' || e.dataSeries.visible) {
    e.dataSeries.visible = false;
  }
  else {
    e.dataSeries.visible = true;
  }
  ocupacionCompetencia.render();
}
