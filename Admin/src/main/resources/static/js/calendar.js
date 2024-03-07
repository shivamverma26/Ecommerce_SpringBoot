"use strict";

(function($, window){
    function startOfDay(date) {
        const clonedDate = new Date(date);

        clonedDate.setHours(0);
        clonedDate.setMinutes(0);
        clonedDate.setSeconds(0);
        clonedDate.setMilliseconds(0);

        return clonedDate;
    }

    function startOfMonth(date) {
        const clonedDate = startOfDay(new Date(date));

        clonedDate.setDate(1);

        return clonedDate;
    }

    function getCalendarHeight() {
        if (window.matchMedia('(min-width: 1600px)').matches) {
            return '100%';
        } else {
            return 'auto';
        }
    }

    $('#calendar').each(function () {
        const calendarEl = this;
        const curYear = (new Date()).getFullYear();
        const curMonth = ('0' + ((new Date()).getMonth() + 1)).substr(-2);
        const eventsSources = [
            {
                events: [
                    {
                        title: 'E3 Electronic Entertainment Expo',
                        start: curYear + '-' + curMonth + '-01',
                        end: curYear + '-' + curMonth + '-05',
                        color: '#DB4343',
                        textColor: '#fff',
                    },
                    {
                        title: 'Adam\'s birthday',
                        start: curYear + '-' + curMonth + '-06',
                        color: '#f69a2f',
                        textColor: '#fff',
                    },
                    {
                        title: 'Stroyka HTML release',
                        start: curYear + '-' + curMonth + '-19',
                        color: '#ffd333',
                        textColor: '#212529',
                    },
                    {
                        title: 'Stroyka Angular release',
                        start: curYear + '-' + curMonth + '-28',
                        color: '#dd0032',
                        textColor: '#fff',
                    },
                    {
                        title: 'Stroyka React release',
                        start: curYear + '-' + curMonth + '-14',
                        color: '#61dafd',
                        textColor: '#292c36',
                    },
                    {
                        title: 'Stroyka Vue release',
                        start: curYear + '-' + curMonth + '-02',
                        color: '#43b885',
                        textColor: '#fff',
                    },
                    {
                        title: 'Annual leave',
                        start: curYear + '-' + curMonth + '-24',
                        end: curYear + '-' + curMonth + '-28',
                        color: '#4275c2',
                        textColor: '#fff',
                    },
                    {
                        title: 'Moscow JavaScript Conference',
                        start: curYear + '-' + curMonth + '-11',
                        end: curYear + '-' + curMonth + '-13',
                        color: '#7a42c2',
                        textColor: '#fff',
                    },
                    {
                        title: 'Russian Hacker\'s Day',
                        start: curYear + '-' + curMonth + '-16',
                        color: '#c33994',
                        textColor: '#fff',
                    },
                ],
            }
        ];
        const datepicker = $('.sa-calendar-datepicker').datepicker({
            language: 'en',
            classes: 'datepicker-sa-embedded',
            inline: true,
            onRenderCell: function (date, cellType) {
                if (cellType === 'day') {
                    const currentDay = date.getTime();
                    let dotsHtml = '';

                    eventsSources.forEach(function(eventSource) {
                        eventSource.events.map(function(event) {
                            const startDate = startOfDay(new Date(event.start)).getTime();
                            const endDate = event.end ? startOfDay(new Date(event.end)).getTime() : startDate;

                            if (
                                (startDate < currentDay && endDate > currentDay) ||
                                (startDate === currentDay)
                            ) {
                                dotsHtml += '<div class="datepicker-sa-dot" style="--datepicker-sa-dot--color: ' + event.color + '"></div>';
                            }
                        });
                    });

                    if (dotsHtml) {
                        return {
                            html: date.getDate()
                                + '<div class="datepicker-sa-dots">'
                                + dotsHtml
                                + '</div>'
                        }
                    }
                }
            },
            onSelect: function onSelect(fd, date) {
                if (date) {
                    calendar.changeView('timeGridDay', date);
                } else if (calendar.view.type === 'timeGridDay') {
                    calendar.changeView('dayGridMonth');
                }
            },
        }).data('datepicker');
        const calendar = new FullCalendar.Calendar(calendarEl, {
            initialView: 'dayGridMonth',
            customButtons: {
                'sa-sidebar': {
                    text: '',
                    click: function() {
                        window.stroyka.layoutSidebar.open();
                    }
                }
            },
            viewDidMount: function() {
                calendarEl.querySelectorAll('.fc-sa-sidebar-button').forEach((button) => {
                    if (button.classList.contains('fc-sa-sidebar-button')) {
                        button.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor"><path d="M7,14v-2h9v2H7z M14,7h2v2h-2V7z M12.5,6C12.8,6,13,6.2,13,6.5v3c0,0.3-0.2,0.5-0.5,0.5h-2 C10.2,10,10,9.8,10,9.5v-3C10,6.2,10.2,6,10.5,6H12.5z M7,2h9v2H7V2z M5.5,5h-2C3.2,5,3,4.8,3,4.5v-3C3,1.2,3.2,1,3.5,1h2 C5.8,1,6,1.2,6,1.5v3C6,4.8,5.8,5,5.5,5z M0,2h2v2H0V2z M9,9H0V7h9V9z M2,14H0v-2h2V14z M3.5,11h2C5.8,11,6,11.2,6,11.5v3 C6,14.8,5.8,15,5.5,15h-2C3.2,15,3,14.8,3,14.5v-3C3,11.2,3.2,11,3.5,11z"></path></svg>';
                    }
                });
            },
            headerToolbar: {
                left: 'sa-sidebar prev,next today',
                center: 'title',
                right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
            },
            height: getCalendarHeight(),
            navLinks: true,
            buttonText: {
                today: 'Today',
                month: 'Month',
                week: 'Week',
                day: 'Day',
                list: 'List',
            },
            editable: true,
            selectable: true,
            selectMirror: true,
            droppable: true,

            select: function(info) {
                const eventTitle = prompt('Enter a title for the new event:');

                if (eventTitle) {
                    calendar.addEvent({
                        title: eventTitle,
                        start: info.start,
                        end: info.end,
                        allDay: info.allDay,
                    });
                }

                calendar.unselect();
            },

            eventClick: function(info) {
                if (confirm('Are you sure you want to delete this event?')) {
                    info.event.remove();
                }
            },
            eventSources: eventsSources,
            datesSet: function(event) {
                if (['dayGridMonth', 'timeGridWeek', 'listWeek'].includes(event.view.type)) {
                    datepicker.clear();
                    const startMonth = startOfMonth(event.start);

                    if (event.view.type === 'dayGridMonth' && event.start.getDate() !== 1) {
                        startMonth.setMonth(startMonth.getMonth() + 1);
                    }

                    if (startMonth.getTime() !== startOfMonth(datepicker.date).getTime()) {
                        datepicker.date = startMonth;
                    }
                } else if (event.view.type === 'timeGridDay') {
                    const selectedDates = datepicker.selectedDates.map(function(date) {
                        return startOfDay(date).getTime();
                    });

                    if (selectedDates.length !== 1 || selectedDates[0] !== startOfDay(event.start).getTime()) {
                        datepicker.selectDate(event.start);
                    }
                }
            },
            windowResize: function() {
                calendar.setOption('height', getCalendarHeight());
            },
        });

        calendar.render();
    });
}(jQuery, window));
