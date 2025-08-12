export interface DateInfo {
    date: string;
    formattedDate: string;
    dayOfWeek: string;
}

export interface UserSettings {
    dateFormat: string;
    timezone: string;
}

export type DateAction = 'fetch' | 'process' | 'display';