function solution(fees, records) {
    let rLen = records.length;
    let fullDay = 60*23+59;
    let sortedRecords = [];
    records.forEach(record => {
        let r = record.split(' ');
        sortedRecords.push({time: r[0], carNum: r[1], inout: r[2]});

    })
    sortedRecords.sort((a, b) => a.carNum-b.carNum);
    let carNums = [... new Set(sortedRecords.map(v=>v.carNum))];
    let times = [];
    sortedRecords.forEach(sr => {
        let [hour, min] = sr.time.split(':');
        let t = hour*60+Number(min);
        if (sr.inout === "IN") t = -t;
        if (!times[carNums.indexOf(sr.carNum)]) times[carNums.indexOf(sr.carNum)] = t;
        else times[carNums.indexOf(sr.carNum)] += t;
    })
    let answer = [];
    times.forEach(t => {
        if (t<=0) t += fullDay;
        if (t<=fees[0]) answer.push(fees[1]);
        else answer.push(fees[1]+Math.ceil((t-fees[0])/fees[2])*fees[3])
    })

    return answer;
}