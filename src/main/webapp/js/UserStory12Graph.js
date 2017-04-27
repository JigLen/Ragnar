/**
 * Created by C07589301 on 26/04/2017.
 */

$("#graph12").click(function() {
    alert("test");
    makeChart();
    $("#graphContainer12").show();
});
function makeChart() {
    var chart;
    chart = Highcharts.chart('graphContainer', {

        title: {
            text: 'Top 10 IMSI\'s that had call failures during a given period'
        },

        data: {
            table: "tablebodyUs12"
        },

        xAxis: {
            allowDecimals: false,
            categories: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
            ,
            crosshair: true
        },

        yAxis: {
            min: 0,
            title: {
                text: 'Number of call failures'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">Failures: </td>' +
            '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },

        series: [{
            name: 'Failures',
            type: 'column',
            colorByPoint: true,
            showInLegend: false
        }]

    });


    $('#plain').click(function () {
        chart.update({
            chart: {
                inverted: false,
                polar: false
            },
            subtitle: {
                text: 'Plain'
            }
        });
    });

    $('#inverted').click(function () {
        chart.update({
            chart: {
                inverted: true,
                polar: false
            },
            subtitle: {
                text: 'Inverted'
            }
        });
    });

    $('#polar').click(function () {
        chart.update({
            chart: {
                inverted: false,
                polar: true
            },
            subtitle: {
                text: 'Polar'
            }
        });
    });
}