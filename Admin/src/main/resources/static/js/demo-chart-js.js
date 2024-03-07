"use strict";

/* global Chart */

const salesData = [
    (10 / 240) * 1200,
    (26 / 240) * 1200,
    (105 / 240) * 1200,
    (57 / 240) * 1200,
    (94 / 240) * 1200,
    (26 / 240) * 1200,
    (57 / 240) * 1200,
    (48 / 240) * 1200,
    (142 / 240) * 1200,
    (94 / 240) * 1200,
    (128 / 240) * 1200,
    (222 / 240) * 1200,
];

const browsersData = {
    labels: ['Chrome', 'Firefox', 'Opera', 'Edge', 'Safari'],
    datasets: [
        {
            backgroundColor: [
                '#ffd333',
                '#eb5252',
                '#51ad23',
                '#4cb8bf',
                '#498ff2',
            ],
            data: [
                (48 / 240) * 1200,
                (142 / 240) * 1200,
                (94 / 240) * 1200,
                (128 / 240) * 1200,
                (222 / 240) * 1200,
            ],
        },
    ],
};

/*
// Line
*/
(function() {
    const chartCanvas = document.getElementById('example-chart-js-line');

    if (!chartCanvas || !(chartCanvas instanceof HTMLCanvasElement)) {
        return;
    }

    new Chart(chartCanvas.getContext('2d'), {
        type: 'line',
        data: {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
            datasets: [
                {
                    backgroundColor: 'transparent',
                    borderColor: '#ffd333',
                    borderWidth: 3,
                    pointStyle: 'circle',
                    pointRadius: 3,
                    pointBackgroundColor: '#ffd333',
                    data: salesData,
                },
            ],
        },
        options: {
            plugins: {
                legend: {
                    display: false,
                },
            },

            scales: {
                y: {
                    ticks: {
                        fontFamily: 'Roboto',
                        fontSize: 13,
                        fontColor: '#828f99',
                        // Include a dollar sign in the ticks
                        callback: function (value) {
                            return '$' + value;
                        },
                    },
                    gridLines: {
                        lineWidth: 1,
                        color: 'rgba(0, 0, 0, 0.1)',
                        zeroLineWidth: 1,
                        zeroLineColor: 'rgba(0, 0, 0, 0.1)',
                        drawBorder: false,
                    },
                },
                x: {
                    ticks: {
                        fontFamily: 'Roboto',
                        fontSize: 13,
                        fontColor: '#828f99',
                    },
                    gridLines: {
                        display: false,
                    },
                },
            },
        },
    });
}());

/*
// Line Area
*/
(function() {
    const chartCanvas = document.getElementById('example-chart-js-line-area');

    if (!chartCanvas || !(chartCanvas instanceof HTMLCanvasElement)) {
        return;
    }

    new Chart(chartCanvas.getContext('2d'), {
        type: 'line',
        data: {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
            datasets: [
                {
                    backgroundColor: 'rgba(255, 211, 51, 0.2)',
                    borderColor: '#ffd333',
                    borderWidth: 3,
                    pointStyle: 'circle',
                    pointRadius: 3,
                    pointBackgroundColor: '#ffd333',
                    fill: 'origin',
                    data: salesData,
                },
            ],
        },
        options: {
            plugins: {
                legend: {
                    display: false,
                },
            },

            scales: {
                y: {
                    ticks: {
                        fontFamily: 'Roboto',
                        fontSize: 13,
                        fontColor: '#828f99',
                        // Include a dollar sign in the ticks
                        callback: function (value) {
                            return '$' + value;
                        },
                    },
                    gridLines: {
                        lineWidth: 1,
                        color: 'rgba(0, 0, 0, 0.1)',
                        zeroLineWidth: 1,
                        zeroLineColor: 'rgba(0, 0, 0, 0.1)',
                        drawBorder: false,
                    },
                },
                x: {
                    ticks: {
                        fontFamily: 'Roboto',
                        fontSize: 13,
                        fontColor: '#828f99',
                    },
                    gridLines: {
                        display: false,
                    },
                },
            },
        },
    });
}());

/*
// Vertical Bar
*/
(function() {
    const chartCanvas = document.getElementById('example-chart-js-vertical-bar');

    if (!chartCanvas || !(chartCanvas instanceof HTMLCanvasElement)) {
        return;
    }

    new Chart(chartCanvas.getContext('2d'), {
        type: 'bar',
        data: {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
            datasets: [
                {
                    backgroundColor: '#ffd333',
                    borderColor: 'transparent',
                    borderWidth: 0,
                    fill: 'origin',
                    data: salesData,
                },
            ],
        },
        options: {
            plugins: {
                legend: {
                    display: false,
                },
            },

            scales: {
                y: {
                    ticks: {
                        fontFamily: 'Roboto',
                        fontSize: 13,
                        fontColor: '#828f99',
                        // Include a dollar sign in the ticks
                        callback: function (value) {
                            return '$' + value;
                        },
                    },
                    gridLines: {
                        lineWidth: 1,
                        color: 'rgba(0, 0, 0, 0.1)',
                        zeroLineWidth: 1,
                        zeroLineColor: 'rgba(0, 0, 0, 0.1)',
                        drawBorder: false,
                    },
                },
                x: {
                    ticks: {
                        fontFamily: 'Roboto',
                        fontSize: 13,
                        fontColor: '#828f99',
                    },
                    gridLines: {
                        display: false,
                    },
                },
            },
        },
    });
}());

/*
// Horizontal Bar
*/
(function() {
    const chartCanvas = document.getElementById('example-chart-js-horizontal-bar');

    if (!chartCanvas || !(chartCanvas instanceof HTMLCanvasElement)) {
        return;
    }

    new Chart(chartCanvas.getContext('2d'), {
        type: 'bar',
        data: {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
            datasets: [
                {
                    backgroundColor: '#ffd333',
                    borderColor: 'transparent',
                    borderWidth: 0,
                    fill: 'origin',
                    barPercentage: .75,
                    data: salesData,
                },
            ],
        },
        options: {
            indexAxis: 'y',
            aspectRatio: 1.375,

            plugins: {
                legend: {
                    display: false,
                },
            },

            scales: {
                y: {
                    ticks: {
                        fontFamily: 'Roboto',
                        fontSize: 13,
                        fontColor: '#828f99',
                    },
                    gridLines: {
                        display: false,
                    },
                },
                x: {
                    ticks: {
                        fontFamily: 'Roboto',
                        fontSize: 13,
                        fontColor: '#828f99',
                        // Include a dollar sign in the ticks
                        callback: function (value) {
                            return '$' + value;
                        },
                    },
                    gridLines: {
                        lineWidth: 1,
                        color: 'rgba(0, 0, 0, 0.1)',
                        zeroLineWidth: 1,
                        zeroLineColor: 'rgba(0, 0, 0, 0.1)',
                        drawBorder: false,
                    },
                },
            },
        },
    });
}());

/*
// Stacked Bar
*/
(function() {
    const chartCanvas = document.getElementById('example-chart-js-stacked-bar');

    if (!chartCanvas || !(chartCanvas instanceof HTMLCanvasElement)) {
        return;
    }

    new Chart(chartCanvas.getContext('2d'), {
        type: 'bar',
        data: {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
            datasets: [
                {
                    backgroundColor: '#ffd333',
                    borderColor: 'transparent',
                    borderWidth: 0,
                    fill: 'origin',
                    data: salesData,
                },
                {
                    backgroundColor: '#ff8b33',
                    borderColor: 'transparent',
                    borderWidth: 0,
                    fill: 'origin',
                    data: salesData,
                },
            ],
        },
        options: {
            plugins: {
                legend: {
                    display: false,
                },
            },

            scales: {
                y: {
                    stacked: true,
                    ticks: {
                        fontFamily: 'Roboto',
                        fontSize: 13,
                        fontColor: '#828f99',
                        // Include a dollar sign in the ticks
                        callback: function (value) {
                            return '$' + value;
                        },
                    },
                    gridLines: {
                        lineWidth: 1,
                        color: 'rgba(0, 0, 0, 0.1)',
                        zeroLineWidth: 1,
                        zeroLineColor: 'rgba(0, 0, 0, 0.1)',
                        drawBorder: false,
                    },
                },
                x: {
                    stacked: true,
                    ticks: {
                        fontFamily: 'Roboto',
                        fontSize: 13,
                        fontColor: '#828f99',
                    },
                    gridLines: {
                        display: false,
                    },
                },
            },
        },
    });
}());

/*
// Pie
*/
(function() {
    const chartCanvas = document.getElementById('example-chart-js-pie');

    if (!chartCanvas || !(chartCanvas instanceof HTMLCanvasElement)) {
        return;
    }

    new Chart(chartCanvas.getContext('2d'), {
        type: 'pie',
        data: browsersData,
        options: {
            plugins: {
                legend: {
                    display: false,
                },
            },
        },
    });
}());

/*
// Doughnut
*/
(function() {
    const chartCanvas = document.getElementById('example-chart-js-doughnut');

    if (!chartCanvas || !(chartCanvas instanceof HTMLCanvasElement)) {
        return;
    }

    new Chart(chartCanvas.getContext('2d'), {
        type: 'doughnut',
        data: browsersData,
        options: {
            plugins: {
                legend: {
                    display: false,
                },
            },
        },
    });
}());
