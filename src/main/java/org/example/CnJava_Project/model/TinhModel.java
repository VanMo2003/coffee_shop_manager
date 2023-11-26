package org.example.CnJava_Project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class TinhModel implements Serializable {
	private int maTinh;
	private String tenTinh;

	public TinhModel(String tenTinh) {
		this.tenTinh = tenTinh;
	}
	public TinhModel(int maTinh, String tenTinh) {
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
	}

	public int getMaTinh() {
		return maTinh;
	}

	public void setMaTinh(int maTinh) {
		this.maTinh = maTinh;
	}

	public String getTenTinh() {
		return tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

	@Override
	public String toString() {
		return maTinh + " - " + tenTinh;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTinh, tenTinh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TinhModel other = (TinhModel) obj;
		return maTinh == other.maTinh && Objects.equals(tenTinh, other.tenTinh);
	}

	public static ArrayList<TinhModel> getDSTinh(){
		String[] arr_tinh = { "An Giang", "Bà Rịa – Vũng Tàu", "Bạc Liêu", "Bắc Giang", "Bắc Kạn", "Bắc Ninh",
				"Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Cần Thơ",
				"Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam",
				"Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Thành phố Hồ Chí Minh",
				"Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lạng Sơn", "Lào Cai", "Lâm Đồng",
				"Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình",
				"Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình",
				"Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long",
				"Vĩnh Phúc", "Yên Bái" };
		// tạo ra danh sách để lưu trữ các tỉnh
		ArrayList<TinhModel> listTinh = new ArrayList<TinhModel>();

		int i=0;
		for (String tenTinh : arr_tinh) {
			TinhModel t = new TinhModel(i, tenTinh); // tạo ra từng tình thành
			listTinh.add(t); // sau đó thêm vào listTinh
		}
		return listTinh;
	}

	public static String getTinhById(int queQuan) {
		if (queQuan != -1) {
			return TinhModel.getDSTinh().get(queQuan - 1).toString().split("-")[1].trim();
		}
		return null;
	}

	public static TinhModel getTinhByTen(String queQuan) {
		ArrayList<TinhModel> listTinh = TinhModel.getDSTinh();
		for (TinhModel tinh : listTinh) {
			if(tinh.getTenTinh().equals(queQuan)) {
				return tinh;
			}
		}
		return null;
	}
}
