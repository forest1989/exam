/**
* jQuery dtui v3.0
* 
* Web Site : http://www.dtui.com
*
* Commercial License : http://www.dtui.com/license
*
* Copyright(c) 2012 All Rights Reserved. Shanghai PusSoft Co., Ltd (sxdet) [ detong@sxdet.com ]. 
* 
*/


dtui.locale = "en-US";


/* Date
-----------------------------------------------------------------------------*/

dtui.dateInfo = {
    monthsLong: ["January", "Febraury", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
    monthsShort: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
    daysLong: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
    daysShort: ["Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"],
    quarterLong: ['Q1', 'Q2', 'Q3', 'Q4'],
    quarterShort: ['Q1', 'Q2', 'Q3', 'Q4'],
    halfYearLong: ['first half', 'second half'],
    patterns: {
        "d": "M/d/yyyy",
        "D": "dddd, MMMM dd, yyyy",
        "f": "dddd, MMMM dd, yyyy H:mm tt",
        "F": "dddd, MMMM dd, yyyy H:mm:ss tt",
        "g": "M/d/yyyy H:mm tt",
        "G": "M/d/yyyy H:mm:ss tt",
        "m": "MMMM dd",
        "o": "yyyy-MM-ddTHH:mm:ss.fff",
        "s": "yyyy-MM-ddTHH:mm:ss",
        "t": "H:mm tt",
        "T": "H:mm:ss tt",
        "U": "dddd, MMMM dd, yyyy HH:mm:ss tt",
        "y": "MMM, yyyy"
    },
    tt: {
        "AM": "AM",
        "PM": "PM"
    },
    ten: {
        "Early": "Early",
        "Mid": "Mid",
        "Late": "Late"
    },
    today: 'Today',
    clockType: 24
};

/* Number
-----------------------------------------------------------------------------*/
dtui.cultures["en"] = {
    name: "en",
    numberFormat: {
        number: {
            pattern: ["n", "-n"],
            decimals: 2,
            decimalsSeparator: ".",
            groupSeparator: ",",
            groupSize: [3]
        },
        percent: {
            pattern: ["n %", "-n %"],
            decimals: 2,
            decimalsSeparator: ".",
            groupSeparator: ",",
            groupSize: [3],
            symbol: "%"
        },
        currency: {
            pattern: ["$n", "($n)"],
            decimals: 2,
            decimalsSeparator: ".",
            groupSeparator: ",",
            groupSize: [3],
            symbol: "$"
        }
    }
}
dtui.culture("en");

/* MessageBox
-----------------------------------------------------------------------------*/
if (dtui.MessageBox) {
    dtui.copyTo(dtui.MessageBox, {
        alertTitle: "Alert",
        confirmTitle: "Confirm",
        prompTitle: "Prompt",
        prompMessage: "Input content: ",
        buttonText: {
            ok: "Ok", //"OK",
            cancel: "Cancel", //"Cancel",
            yes: "Yes", //"Yes",
            no: "No"//"No"
        }
    });
};

/* Calendar
-----------------------------------------------------------------------------*/

if (dtui.Calendar) {
    dtui.copyTo(dtui.Calendar.prototype, {
        firstDayOfWeek: 0,
        yesterdayText: "Yesterday",
        todayText: "Today",
        clearText: "Clear",
        okText: "OK",
        cancelText: "Cancel",
        daysShort: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"],
        format: "MMM, yyyy",

        timeFormat: 'H:mm'
    });
}


/* required | loadingMsg
-----------------------------------------------------------------------------*/
for (var id in dtui) {
    var clazz = dtui[id];
    if (clazz && clazz.prototype && clazz.prototype.isControl) {
        clazz.prototype.requiredErrorText = "²»ÄÜÎª¿Õ";
        clazz.prototype.loadingMsg = "Loading...";
    }

}

/* VTypes
-----------------------------------------------------------------------------*/
dtui.copyTo(dtui.VTypes, {
    minDateErrorText: 'Date can not be less than {0}',
    maxDateErrorText: 'Date can not be greater than {0}',

    uniqueErrorText: "This field is unique.",
    requiredErrorText: "This field is required.",
    emailErrorText: "Please enter a valid email address.",
    urlErrorText: "Please enter a valid URL.",
    floatErrorText: "Please enter a valid number.",
    intErrorText: "Please enter only digits",
    dateErrorText: "Please enter a valid date. Date format is {0}",
    maxLengthErrorText: "Please enter no more than {0} characters.",
    minLengthErrorText: "Please enter at least {0} characters.",
    maxErrorText: "Please enter a value less than or equal to {0}.",
    minErrorText: "Please enter a value greater than or equal to {0}.",
    rangeLengthErrorText: "Please enter a value between {0} and {1} characters long.",
    rangeCharErrorText: "Please enter a value between {0} and {1} characters long.",
    rangeErrorText: "Please enter a value between {0} and {1}."
});


if (dtui.FileUpload) {
    dtui.FileUpload.prototype.buttonText = "Browse..."
}
if (dtui.HtmlFile) {
    dtui.HtmlFile.prototype.buttonText = "Browse..."
}

/* Pager
-----------------------------------------------------------------------------*/

if (dtui.Pager) {
    dtui.copyTo(dtui.Pager.prototype, {
        firstText: "First",
        prevText: "Prev",
        nextText: "Next",
        lastText: "Last",
        pageInfoText: "Pre page {0} records , all {1} records."
    });
}

/* DataGrid
-----------------------------------------------------------------------------*/
if (dtui.DataGrid) {
    dtui.copyTo(dtui.DataGrid.prototype, {
        emptyText: "No data returned."
    });
}

/* Gantt
-----------------------------------------------------------------------------*/
if (window.dtui.Gantt) {
    dtui.GanttView.ShortWeeks = [
        "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"
    ];
    dtui.GanttView.LongWeeks = [
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    ];

    dtui.Gantt.PredecessorLinkType = [
        { ID: 0, Name: 'Finish-Finish(FF)', Short: 'FF' },
        { ID: 1, Name: 'Finish-Start(FS)', Short: 'FS' },
        { ID: 2, Name: 'Start-Finish(SF)', Short: 'SF' },
        { ID: 3, Name: 'Start-Start(SS)', Short: 'SS' }
    ];

    dtui.Gantt.ConstraintType = [
        { ID: 0, Name: 'The sooner the better' },
        { ID: 1, Name: 'The later the better' },
        { ID: 2, Name: 'Must be begin in' },
        { ID: 3, Name: 'Must be completed in' },
        { ID: 4, Name: 'Beginning no earlier than ...' },
        { ID: 5, Name: 'Beginning no later than ...' },
        { ID: 6, Name: 'Completed no earlier than ...' },
        { ID: 7, Name: 'Completed no later than ...' }
    ];

    dtui.copyTo(dtui.Gantt, {
        ID_Text: "ID",
        Name_Text: "Name",
        PercentComplete_Text: "Progress",
        Duration_Text: "Duration",
        Start_Text: "Start",
        Finish_Text: "Finish",
        Critical_Text: "Critical",

        PredecessorLink_Text: "PredecessorLink",
        Work_Text: "Work",
        Priority_Text: "Priority",
        Weight_Text: "Weight",
        OutlineNumber_Text: "OutlineNumber",
        OutlineLevel_Text: "OutlineLevel",
        ActualStart_Text: "ActualStart",
        ActualFinish_Text: "ActualFinish",
        WBS_Text: "WBS",
        ConstraintType_Text: "ConstraintType",
        ConstraintDate_Text: "ConstraintDate",
        Department_Text: "Department",
        Principal_Text: "Principal",
        Assignments_Text: "Assignments",

        Summary_Text: "Summary",
        Task_Text: "Task",
        Baseline_Text: "Baseline",
        LinkType_Text: "LinkType",
        LinkLag_Text: "LinkLag",
        From_Text: "From",
        To_Text: "To",

        Goto_Text: "Goto",
        UpGrade_Text: "UpGrade",
        DownGrade_Text: "DownGrade",
        Add_Text: "Add Task",
        Edit_Text: "Edit Task",
        Remove_Text: "Remove Task",
        Move_Text: "Move Task",
        ZoomIn_Text: "ZoomIn",
        ZoomOut_Text: "ZoomOut",
        Deselect_Text: "Un Select",
        Split_Text: "Split Task"


    });
}