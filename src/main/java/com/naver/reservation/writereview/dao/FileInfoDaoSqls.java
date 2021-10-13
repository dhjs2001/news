package com.naver.reservation.writereview.dao;

public class FileInfoDaoSqls {
	public final static String SELECT = "SELECT id, file_name, save_file_name, content_type, delete_flag, create_date, modify_date FROM file_info WHERE id = :id";

}
